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
import py.com.sgipy.miesys.entities.Reunion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Estudio;

/**
 *
 * @author aito8
 */
public class EstudioJpaController implements Serializable {

    public EstudioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudio estudio) {
        if (estudio.getReunionList() == null) {
            estudio.setReunionList(new ArrayList<Reunion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Reunion> attachedReunionList = new ArrayList<Reunion>();
            for (Reunion reunionListReunionToAttach : estudio.getReunionList()) {
                reunionListReunionToAttach = em.getReference(reunionListReunionToAttach.getClass(), reunionListReunionToAttach.getReunion());
                attachedReunionList.add(reunionListReunionToAttach);
            }
            estudio.setReunionList(attachedReunionList);
            em.persist(estudio);
            for (Reunion reunionListReunion : estudio.getReunionList()) {
                Estudio oldEstudioOfReunionListReunion = reunionListReunion.getEstudio();
                reunionListReunion.setEstudio(estudio);
                reunionListReunion = em.merge(reunionListReunion);
                if (oldEstudioOfReunionListReunion != null) {
                    oldEstudioOfReunionListReunion.getReunionList().remove(reunionListReunion);
                    oldEstudioOfReunionListReunion = em.merge(oldEstudioOfReunionListReunion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudio estudio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudio persistentEstudio = em.find(Estudio.class, estudio.getEstudio());
            List<Reunion> reunionListOld = persistentEstudio.getReunionList();
            List<Reunion> reunionListNew = estudio.getReunionList();
            List<Reunion> attachedReunionListNew = new ArrayList<Reunion>();
            for (Reunion reunionListNewReunionToAttach : reunionListNew) {
                reunionListNewReunionToAttach = em.getReference(reunionListNewReunionToAttach.getClass(), reunionListNewReunionToAttach.getReunion());
                attachedReunionListNew.add(reunionListNewReunionToAttach);
            }
            reunionListNew = attachedReunionListNew;
            estudio.setReunionList(reunionListNew);
            estudio = em.merge(estudio);
            for (Reunion reunionListOldReunion : reunionListOld) {
                if (!reunionListNew.contains(reunionListOldReunion)) {
                    reunionListOldReunion.setEstudio(null);
                    reunionListOldReunion = em.merge(reunionListOldReunion);
                }
            }
            for (Reunion reunionListNewReunion : reunionListNew) {
                if (!reunionListOld.contains(reunionListNewReunion)) {
                    Estudio oldEstudioOfReunionListNewReunion = reunionListNewReunion.getEstudio();
                    reunionListNewReunion.setEstudio(estudio);
                    reunionListNewReunion = em.merge(reunionListNewReunion);
                    if (oldEstudioOfReunionListNewReunion != null && !oldEstudioOfReunionListNewReunion.equals(estudio)) {
                        oldEstudioOfReunionListNewReunion.getReunionList().remove(reunionListNewReunion);
                        oldEstudioOfReunionListNewReunion = em.merge(oldEstudioOfReunionListNewReunion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudio.getEstudio();
                if (findEstudio(id) == null) {
                    throw new NonexistentEntityException("The estudio with id " + id + " no longer exists.");
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
            Estudio estudio;
            try {
                estudio = em.getReference(Estudio.class, id);
                estudio.getEstudio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudio with id " + id + " no longer exists.", enfe);
            }
            List<Reunion> reunionList = estudio.getReunionList();
            for (Reunion reunionListReunion : reunionList) {
                reunionListReunion.setEstudio(null);
                reunionListReunion = em.merge(reunionListReunion);
            }
            em.remove(estudio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudio> findEstudioEntities() {
        return findEstudioEntities(true, -1, -1);
    }

    public List<Estudio> findEstudioEntities(int maxResults, int firstResult) {
        return findEstudioEntities(false, maxResults, firstResult);
    }

    private List<Estudio> findEstudioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudio.class));
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

    public Estudio findEstudio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudio.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudio> rt = cq.from(Estudio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
