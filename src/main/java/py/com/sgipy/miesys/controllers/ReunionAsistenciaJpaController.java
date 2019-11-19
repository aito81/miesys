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
            em.persist(reunionAsistencia);
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
            reunionAsistencia = em.merge(reunionAsistencia);
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
