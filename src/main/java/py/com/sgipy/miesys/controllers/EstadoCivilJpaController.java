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
import py.com.sgipy.miesys.entities.EstadoCivil;

/**
 *
 * @author aito8
 */
public class EstadoCivilJpaController implements Serializable {

    public EstadoCivilJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadoCivil estadoCivil) {
        if (estadoCivil.getPersonaList() == null) {
            estadoCivil.setPersonaList(new ArrayList<Persona>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : estadoCivil.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            estadoCivil.setPersonaList(attachedPersonaList);
            em.persist(estadoCivil);
            for (Persona personaListPersona : estadoCivil.getPersonaList()) {
                EstadoCivil oldEstadoCivilOfPersonaListPersona = personaListPersona.getEstadoCivil();
                personaListPersona.setEstadoCivil(estadoCivil);
                personaListPersona = em.merge(personaListPersona);
                if (oldEstadoCivilOfPersonaListPersona != null) {
                    oldEstadoCivilOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldEstadoCivilOfPersonaListPersona = em.merge(oldEstadoCivilOfPersonaListPersona);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadoCivil estadoCivil) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadoCivil persistentEstadoCivil = em.find(EstadoCivil.class, estadoCivil.getEstadoCivil());
            List<Persona> personaListOld = persistentEstadoCivil.getPersonaList();
            List<Persona> personaListNew = estadoCivil.getPersonaList();
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            estadoCivil.setPersonaList(personaListNew);
            estadoCivil = em.merge(estadoCivil);
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    personaListOldPersona.setEstadoCivil(null);
                    personaListOldPersona = em.merge(personaListOldPersona);
                }
            }
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    EstadoCivil oldEstadoCivilOfPersonaListNewPersona = personaListNewPersona.getEstadoCivil();
                    personaListNewPersona.setEstadoCivil(estadoCivil);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldEstadoCivilOfPersonaListNewPersona != null && !oldEstadoCivilOfPersonaListNewPersona.equals(estadoCivil)) {
                        oldEstadoCivilOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldEstadoCivilOfPersonaListNewPersona = em.merge(oldEstadoCivilOfPersonaListNewPersona);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estadoCivil.getEstadoCivil();
                if (findEstadoCivil(id) == null) {
                    throw new NonexistentEntityException("The estadoCivil with id " + id + " no longer exists.");
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
            EstadoCivil estadoCivil;
            try {
                estadoCivil = em.getReference(EstadoCivil.class, id);
                estadoCivil.getEstadoCivil();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoCivil with id " + id + " no longer exists.", enfe);
            }
            List<Persona> personaList = estadoCivil.getPersonaList();
            for (Persona personaListPersona : personaList) {
                personaListPersona.setEstadoCivil(null);
                personaListPersona = em.merge(personaListPersona);
            }
            em.remove(estadoCivil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadoCivil> findEstadoCivilEntities() {
        return findEstadoCivilEntities(true, -1, -1);
    }

    public List<EstadoCivil> findEstadoCivilEntities(int maxResults, int firstResult) {
        return findEstadoCivilEntities(false, maxResults, firstResult);
    }

    private List<EstadoCivil> findEstadoCivilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadoCivil.class));
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

    public EstadoCivil findEstadoCivil(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadoCivil.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoCivilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadoCivil> rt = cq.from(EstadoCivil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
