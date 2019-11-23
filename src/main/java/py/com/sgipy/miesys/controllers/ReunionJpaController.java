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
import py.com.sgipy.miesys.entities.Estudio;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Reunion;

/**
 *
 * @author Santiago
 */
public class ReunionJpaController implements Serializable {

    public ReunionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reunion reunion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudio estudio = reunion.getEstudio();
            if (estudio != null) {
                estudio = em.getReference(estudio.getClass(), estudio.getEstudio());
                reunion.setEstudio(estudio);
            }
            Han han = reunion.getHan();
            if (han != null) {
                han = em.getReference(han.getClass(), han.getHan());
                reunion.setHan(han);
            }
            em.persist(reunion);
            if (estudio != null) {
                estudio.getReunionList().add(reunion);
                estudio = em.merge(estudio);
            }
            if (han != null) {
                han.getReunionList().add(reunion);
                han = em.merge(han);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reunion reunion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reunion persistentReunion = em.find(Reunion.class, reunion.getReunion());
            Estudio estudioOld = persistentReunion.getEstudio();
            Estudio estudioNew = reunion.getEstudio();
            Han hanOld = persistentReunion.getHan();
            Han hanNew = reunion.getHan();
            if (estudioNew != null) {
                estudioNew = em.getReference(estudioNew.getClass(), estudioNew.getEstudio());
                reunion.setEstudio(estudioNew);
            }
            if (hanNew != null) {
                hanNew = em.getReference(hanNew.getClass(), hanNew.getHan());
                reunion.setHan(hanNew);
            }
            reunion = em.merge(reunion);
            if (estudioOld != null && !estudioOld.equals(estudioNew)) {
                estudioOld.getReunionList().remove(reunion);
                estudioOld = em.merge(estudioOld);
            }
            if (estudioNew != null && !estudioNew.equals(estudioOld)) {
                estudioNew.getReunionList().add(reunion);
                estudioNew = em.merge(estudioNew);
            }
            if (hanOld != null && !hanOld.equals(hanNew)) {
                hanOld.getReunionList().remove(reunion);
                hanOld = em.merge(hanOld);
            }
            if (hanNew != null && !hanNew.equals(hanOld)) {
                hanNew.getReunionList().add(reunion);
                hanNew = em.merge(hanNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reunion.getReunion();
                if (findReunion(id) == null) {
                    throw new NonexistentEntityException("The reunion with id " + id + " no longer exists.");
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
            Reunion reunion;
            try {
                reunion = em.getReference(Reunion.class, id);
                reunion.getReunion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reunion with id " + id + " no longer exists.", enfe);
            }
            Estudio estudio = reunion.getEstudio();
            if (estudio != null) {
                estudio.getReunionList().remove(reunion);
                estudio = em.merge(estudio);
            }
            Han han = reunion.getHan();
            if (han != null) {
                han.getReunionList().remove(reunion);
                han = em.merge(han);
            }
            em.remove(reunion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reunion> findReunionEntities() {
        return findReunionEntities(true, -1, -1);
    }

    public List<Reunion> findReunionEntities(int maxResults, int firstResult) {
        return findReunionEntities(false, maxResults, firstResult);
    }

    private List<Reunion> findReunionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reunion.class));
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

    public Reunion findReunion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reunion.class, id);
        } finally {
            em.close();
        }
    }

    public int getReunionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reunion> rt = cq.from(Reunion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
