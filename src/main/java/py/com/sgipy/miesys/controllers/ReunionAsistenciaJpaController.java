/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.sgipy.miesys.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.Reunion;
import py.com.sgipy.miesys.entities.ReunionAsistencia;

/**
 *
 * @author aito8
 */
public class ReunionAsistenciaJpaController implements Serializable {

    public ReunionAsistenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReunionAsistencia reunionAsistencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona = reunionAsistencia.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getPersona());
                reunionAsistencia.setPersona(persona);
            }
            Reunion reunion = reunionAsistencia.getReunion();
            if (reunion != null) {
                reunion = em.getReference(reunion.getClass(), reunion.getReunion());
                reunionAsistencia.setReunion(reunion);
            }
            em.persist(reunionAsistencia);
            if (persona != null) {
                persona.getReunionAsistenciaList().add(reunionAsistencia);
                persona = em.merge(persona);
            }
            if (reunion != null) {
                reunion.getReunionAsistenciaList().add(reunionAsistencia);
                reunion = em.merge(reunion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReunionAsistencia reunionAsistencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ReunionAsistencia persistentReunionAsistencia = em.find(ReunionAsistencia.class, reunionAsistencia.getReunionAsistencia());
            Persona personaOld = persistentReunionAsistencia.getPersona();
            Persona personaNew = reunionAsistencia.getPersona();
            Reunion reunionOld = persistentReunionAsistencia.getReunion();
            Reunion reunionNew = reunionAsistencia.getReunion();
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getPersona());
                reunionAsistencia.setPersona(personaNew);
            }
            if (reunionNew != null) {
                reunionNew = em.getReference(reunionNew.getClass(), reunionNew.getReunion());
                reunionAsistencia.setReunion(reunionNew);
            }
            reunionAsistencia = em.merge(reunionAsistencia);
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.getReunionAsistenciaList().remove(reunionAsistencia);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.getReunionAsistenciaList().add(reunionAsistencia);
                personaNew = em.merge(personaNew);
            }
            if (reunionOld != null && !reunionOld.equals(reunionNew)) {
                reunionOld.getReunionAsistenciaList().remove(reunionAsistencia);
                reunionOld = em.merge(reunionOld);
            }
            if (reunionNew != null && !reunionNew.equals(reunionOld)) {
                reunionNew.getReunionAsistenciaList().add(reunionAsistencia);
                reunionNew = em.merge(reunionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reunionAsistencia.getReunionAsistencia();
                if (findReunionAsistencia(id) == null) {
                    throw new NonexistentEntityException("The reunionAsistencia with id " + id + " no longer exists.");
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
            ReunionAsistencia reunionAsistencia;
            try {
                reunionAsistencia = em.getReference(ReunionAsistencia.class, id);
                reunionAsistencia.getReunionAsistencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reunionAsistencia with id " + id + " no longer exists.", enfe);
            }
            Persona persona = reunionAsistencia.getPersona();
            if (persona != null) {
                persona.getReunionAsistenciaList().remove(reunionAsistencia);
                persona = em.merge(persona);
            }
            Reunion reunion = reunionAsistencia.getReunion();
            if (reunion != null) {
                reunion.getReunionAsistenciaList().remove(reunionAsistencia);
                reunion = em.merge(reunion);
            }
            em.remove(reunionAsistencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReunionAsistencia> findReunionAsistenciaEntities() {
        return findReunionAsistenciaEntities(true, -1, -1);
    }

    public List<ReunionAsistencia> findReunionAsistenciaEntities(int maxResults, int firstResult) {
        return findReunionAsistenciaEntities(false, maxResults, firstResult);
    }

    private List<ReunionAsistencia> findReunionAsistenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReunionAsistencia.class));
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

    public ReunionAsistencia findReunionAsistencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReunionAsistencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getReunionAsistenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReunionAsistencia> rt = cq.from(ReunionAsistencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
