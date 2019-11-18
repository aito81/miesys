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
import py.com.sgipy.miesys.entities.Division;

/**
 *
 * @author aito8
 */
public class DivisionJpaController implements Serializable {

    public DivisionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Division division) {
        if (division.getPersonaList() == null) {
            division.setPersonaList(new ArrayList<Persona>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : division.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            division.setPersonaList(attachedPersonaList);
            em.persist(division);
            for (Persona personaListPersona : division.getPersonaList()) {
                Division oldDivisionOfPersonaListPersona = personaListPersona.getDivision();
                personaListPersona.setDivision(division);
                personaListPersona = em.merge(personaListPersona);
                if (oldDivisionOfPersonaListPersona != null) {
                    oldDivisionOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldDivisionOfPersonaListPersona = em.merge(oldDivisionOfPersonaListPersona);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Division division) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Division persistentDivision = em.find(Division.class, division.getDivision());
            List<Persona> personaListOld = persistentDivision.getPersonaList();
            List<Persona> personaListNew = division.getPersonaList();
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            division.setPersonaList(personaListNew);
            division = em.merge(division);
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    personaListOldPersona.setDivision(null);
                    personaListOldPersona = em.merge(personaListOldPersona);
                }
            }
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    Division oldDivisionOfPersonaListNewPersona = personaListNewPersona.getDivision();
                    personaListNewPersona.setDivision(division);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldDivisionOfPersonaListNewPersona != null && !oldDivisionOfPersonaListNewPersona.equals(division)) {
                        oldDivisionOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldDivisionOfPersonaListNewPersona = em.merge(oldDivisionOfPersonaListNewPersona);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = division.getDivision();
                if (findDivision(id) == null) {
                    throw new NonexistentEntityException("The division with id " + id + " no longer exists.");
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
            Division division;
            try {
                division = em.getReference(Division.class, id);
                division.getDivision();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The division with id " + id + " no longer exists.", enfe);
            }
            List<Persona> personaList = division.getPersonaList();
            for (Persona personaListPersona : personaList) {
                personaListPersona.setDivision(null);
                personaListPersona = em.merge(personaListPersona);
            }
            em.remove(division);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Division> findDivisionEntities() {
        return findDivisionEntities(true, -1, -1);
    }

    public List<Division> findDivisionEntities(int maxResults, int firstResult) {
        return findDivisionEntities(false, maxResults, firstResult);
    }

    private List<Division> findDivisionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Division.class));
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

    public Division findDivision(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Division.class, id);
        } finally {
            em.close();
        }
    }

    public int getDivisionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Division> rt = cq.from(Division.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
