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
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Nacionalidad;

/**
 *
 * @author Santiago
 */
public class NacionalidadJpaController implements Serializable {

    public NacionalidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nacionalidad nacionalidad) {
        if (nacionalidad.getPersonaList() == null) {
            nacionalidad.setPersonaList(new ArrayList<Persona>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : nacionalidad.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            nacionalidad.setPersonaList(attachedPersonaList);
            em.persist(nacionalidad);
            for (Persona personaListPersona : nacionalidad.getPersonaList()) {
                Nacionalidad oldNacionalidadOfPersonaListPersona = personaListPersona.getNacionalidad();
                personaListPersona.setNacionalidad(nacionalidad);
                personaListPersona = em.merge(personaListPersona);
                if (oldNacionalidadOfPersonaListPersona != null) {
                    oldNacionalidadOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldNacionalidadOfPersonaListPersona = em.merge(oldNacionalidadOfPersonaListPersona);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nacionalidad nacionalidad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nacionalidad persistentNacionalidad = em.find(Nacionalidad.class, nacionalidad.getNacionalidad());
            List<Persona> personaListOld = persistentNacionalidad.getPersonaList();
            List<Persona> personaListNew = nacionalidad.getPersonaList();
            List<String> illegalOrphanMessages = null;
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Persona " + personaListOldPersona + " since its nacionalidad field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            nacionalidad.setPersonaList(personaListNew);
            nacionalidad = em.merge(nacionalidad);
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    Nacionalidad oldNacionalidadOfPersonaListNewPersona = personaListNewPersona.getNacionalidad();
                    personaListNewPersona.setNacionalidad(nacionalidad);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldNacionalidadOfPersonaListNewPersona != null && !oldNacionalidadOfPersonaListNewPersona.equals(nacionalidad)) {
                        oldNacionalidadOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldNacionalidadOfPersonaListNewPersona = em.merge(oldNacionalidadOfPersonaListNewPersona);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nacionalidad.getNacionalidad();
                if (findNacionalidad(id) == null) {
                    throw new NonexistentEntityException("The nacionalidad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nacionalidad nacionalidad;
            try {
                nacionalidad = em.getReference(Nacionalidad.class, id);
                nacionalidad.getNacionalidad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nacionalidad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Persona> personaListOrphanCheck = nacionalidad.getPersonaList();
            for (Persona personaListOrphanCheckPersona : personaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Nacionalidad (" + nacionalidad + ") cannot be destroyed since the Persona " + personaListOrphanCheckPersona + " in its personaList field has a non-nullable nacionalidad field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(nacionalidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nacionalidad> findNacionalidadEntities() {
        return findNacionalidadEntities(true, -1, -1);
    }

    public List<Nacionalidad> findNacionalidadEntities(int maxResults, int firstResult) {
        return findNacionalidadEntities(false, maxResults, firstResult);
    }

    private List<Nacionalidad> findNacionalidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nacionalidad.class));
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

    public Nacionalidad findNacionalidad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nacionalidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getNacionalidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nacionalidad> rt = cq.from(Nacionalidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
