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
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Han;

/**
 *
 * @author aito8
 */
public class HanJpaController implements Serializable {

    public HanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Han han) {
        if (han.getPersonaList() == null) {
            han.setPersonaList(new ArrayList<Persona>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Distrito distrito = han.getDistrito();
            if (distrito != null) {
                distrito = em.getReference(distrito.getClass(), distrito.getDistrito());
                han.setDistrito(distrito);
            }
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : han.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            han.setPersonaList(attachedPersonaList);
            em.persist(han);
            if (distrito != null) {
                distrito.getHanList().add(han);
                distrito = em.merge(distrito);
            }
            for (Persona personaListPersona : han.getPersonaList()) {
                Han oldHanOfPersonaListPersona = personaListPersona.getHan();
                personaListPersona.setHan(han);
                personaListPersona = em.merge(personaListPersona);
                if (oldHanOfPersonaListPersona != null) {
                    oldHanOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldHanOfPersonaListPersona = em.merge(oldHanOfPersonaListPersona);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Han han) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Han persistentHan = em.find(Han.class, han.getHan());
            Distrito distritoOld = persistentHan.getDistrito();
            Distrito distritoNew = han.getDistrito();
            List<Persona> personaListOld = persistentHan.getPersonaList();
            List<Persona> personaListNew = han.getPersonaList();
            if (distritoNew != null) {
                distritoNew = em.getReference(distritoNew.getClass(), distritoNew.getDistrito());
                han.setDistrito(distritoNew);
            }
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            han.setPersonaList(personaListNew);
            han = em.merge(han);
            if (distritoOld != null && !distritoOld.equals(distritoNew)) {
                distritoOld.getHanList().remove(han);
                distritoOld = em.merge(distritoOld);
            }
            if (distritoNew != null && !distritoNew.equals(distritoOld)) {
                distritoNew.getHanList().add(han);
                distritoNew = em.merge(distritoNew);
            }
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    personaListOldPersona.setHan(null);
                    personaListOldPersona = em.merge(personaListOldPersona);
                }
            }
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    Han oldHanOfPersonaListNewPersona = personaListNewPersona.getHan();
                    personaListNewPersona.setHan(han);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldHanOfPersonaListNewPersona != null && !oldHanOfPersonaListNewPersona.equals(han)) {
                        oldHanOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldHanOfPersonaListNewPersona = em.merge(oldHanOfPersonaListNewPersona);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = han.getHan();
                if (findHan(id) == null) {
                    throw new NonexistentEntityException("The han with id " + id + " no longer exists.");
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
            Han han;
            try {
                han = em.getReference(Han.class, id);
                han.getHan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The han with id " + id + " no longer exists.", enfe);
            }
            Distrito distrito = han.getDistrito();
            if (distrito != null) {
                distrito.getHanList().remove(han);
                distrito = em.merge(distrito);
            }
            List<Persona> personaList = han.getPersonaList();
            for (Persona personaListPersona : personaList) {
                personaListPersona.setHan(null);
                personaListPersona = em.merge(personaListPersona);
            }
            em.remove(han);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Han> findHanEntities() {
        return findHanEntities(true, -1, -1);
    }

    public List<Han> findHanEntities(int maxResults, int firstResult) {
        return findHanEntities(false, maxResults, firstResult);
    }

    private List<Han> findHanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Han.class));
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

    public Han findHan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Han.class, id);
        } finally {
            em.close();
        }
    }

    public int getHanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Han> rt = cq.from(Han.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
