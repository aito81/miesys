/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.sgipy.miesys.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import py.com.sgipy.miesys.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Ocupacion;

/**
 *
 * @author Santiago
 */
public class OcupacionJpaController implements Serializable {

    public OcupacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ocupacion ocupacion) {
        if (ocupacion.getPersonaList() == null) {
            ocupacion.setPersonaList(new ArrayList<Persona>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : ocupacion.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            ocupacion.setPersonaList(attachedPersonaList);
            em.persist(ocupacion);
            for (Persona personaListPersona : ocupacion.getPersonaList()) {
                Ocupacion oldOcupacionOfPersonaListPersona = personaListPersona.getOcupacion();
                personaListPersona.setOcupacion(ocupacion);
                personaListPersona = em.merge(personaListPersona);
                if (oldOcupacionOfPersonaListPersona != null) {
                    oldOcupacionOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldOcupacionOfPersonaListPersona = em.merge(oldOcupacionOfPersonaListPersona);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ocupacion ocupacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ocupacion persistentOcupacion = em.find(Ocupacion.class, ocupacion.getOcupacion());
            List<Persona> personaListOld = persistentOcupacion.getPersonaList();
            List<Persona> personaListNew = ocupacion.getPersonaList();
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            ocupacion.setPersonaList(personaListNew);
            ocupacion = em.merge(ocupacion);
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    personaListOldPersona.setOcupacion(null);
                    personaListOldPersona = em.merge(personaListOldPersona);
                }
            }
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    Ocupacion oldOcupacionOfPersonaListNewPersona = personaListNewPersona.getOcupacion();
                    personaListNewPersona.setOcupacion(ocupacion);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldOcupacionOfPersonaListNewPersona != null && !oldOcupacionOfPersonaListNewPersona.equals(ocupacion)) {
                        oldOcupacionOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldOcupacionOfPersonaListNewPersona = em.merge(oldOcupacionOfPersonaListNewPersona);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ocupacion.getOcupacion();
                if (findOcupacion(id) == null) {
                    throw new NonexistentEntityException("The ocupacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ocupacion ocupacion;
            try {
                ocupacion = em.getReference(Ocupacion.class, id);
                ocupacion.getOcupacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ocupacion with id " + id + " no longer exists.", enfe);
            }
            List<Persona> personaList = ocupacion.getPersonaList();
            for (Persona personaListPersona : personaList) {
                personaListPersona.setOcupacion(null);
                personaListPersona = em.merge(personaListPersona);
            }
            em.remove(ocupacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ocupacion> findOcupacionEntities() {
        return findOcupacionEntities(true, -1, -1);
    }

    public List<Ocupacion> findOcupacionEntities(int maxResults, int firstResult) {
        return findOcupacionEntities(false, maxResults, firstResult);
    }

    private List<Ocupacion> findOcupacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ocupacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ocupacion findOcupacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ocupacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getOcupacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ocupacion> rt = cq.from(Ocupacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
