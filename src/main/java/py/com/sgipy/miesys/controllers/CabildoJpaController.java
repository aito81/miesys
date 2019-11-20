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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Cabildo;

/**
 *
 * @author Santiago
 */
public class CabildoJpaController implements Serializable {

    public CabildoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cabildo cabildo) {
        if (cabildo.getDistritoList() == null) {
            cabildo.setDistritoList(new ArrayList<Distrito>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Distrito> attachedDistritoList = new ArrayList<Distrito>();
            for (Distrito distritoListDistritoToAttach : cabildo.getDistritoList()) {
                distritoListDistritoToAttach = em.getReference(distritoListDistritoToAttach.getClass(), distritoListDistritoToAttach.getDistrito());
                attachedDistritoList.add(distritoListDistritoToAttach);
            }
            cabildo.setDistritoList(attachedDistritoList);
            em.persist(cabildo);
            for (Distrito distritoListDistrito : cabildo.getDistritoList()) {
                Cabildo oldCabildoOfDistritoListDistrito = distritoListDistrito.getCabildo();
                distritoListDistrito.setCabildo(cabildo);
                distritoListDistrito = em.merge(distritoListDistrito);
                if (oldCabildoOfDistritoListDistrito != null) {
                    oldCabildoOfDistritoListDistrito.getDistritoList().remove(distritoListDistrito);
                    oldCabildoOfDistritoListDistrito = em.merge(oldCabildoOfDistritoListDistrito);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cabildo cabildo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cabildo persistentCabildo = em.find(Cabildo.class, cabildo.getCabildo());
            List<Distrito> distritoListOld = persistentCabildo.getDistritoList();
            List<Distrito> distritoListNew = cabildo.getDistritoList();
            List<String> illegalOrphanMessages = null;
            for (Distrito distritoListOldDistrito : distritoListOld) {
                if (!distritoListNew.contains(distritoListOldDistrito)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Distrito " + distritoListOldDistrito + " since its cabildo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Distrito> attachedDistritoListNew = new ArrayList<Distrito>();
            for (Distrito distritoListNewDistritoToAttach : distritoListNew) {
                distritoListNewDistritoToAttach = em.getReference(distritoListNewDistritoToAttach.getClass(), distritoListNewDistritoToAttach.getDistrito());
                attachedDistritoListNew.add(distritoListNewDistritoToAttach);
            }
            distritoListNew = attachedDistritoListNew;
            cabildo.setDistritoList(distritoListNew);
            cabildo = em.merge(cabildo);
            for (Distrito distritoListNewDistrito : distritoListNew) {
                if (!distritoListOld.contains(distritoListNewDistrito)) {
                    Cabildo oldCabildoOfDistritoListNewDistrito = distritoListNewDistrito.getCabildo();
                    distritoListNewDistrito.setCabildo(cabildo);
                    distritoListNewDistrito = em.merge(distritoListNewDistrito);
                    if (oldCabildoOfDistritoListNewDistrito != null && !oldCabildoOfDistritoListNewDistrito.equals(cabildo)) {
                        oldCabildoOfDistritoListNewDistrito.getDistritoList().remove(distritoListNewDistrito);
                        oldCabildoOfDistritoListNewDistrito = em.merge(oldCabildoOfDistritoListNewDistrito);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cabildo.getCabildo();
                if (findCabildo(id) == null) {
                    throw new NonexistentEntityException("The cabildo with id " + id + " no longer exists.");
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
            Cabildo cabildo;
            try {
                cabildo = em.getReference(Cabildo.class, id);
                cabildo.getCabildo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cabildo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Distrito> distritoListOrphanCheck = cabildo.getDistritoList();
            for (Distrito distritoListOrphanCheckDistrito : distritoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cabildo (" + cabildo + ") cannot be destroyed since the Distrito " + distritoListOrphanCheckDistrito + " in its distritoList field has a non-nullable cabildo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cabildo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cabildo> findCabildoEntities() {
        return findCabildoEntities(true, -1, -1);
    }

    public List<Cabildo> findCabildoEntities(int maxResults, int firstResult) {
        return findCabildoEntities(false, maxResults, firstResult);
    }

    private List<Cabildo> findCabildoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cabildo.class));
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

    public Cabildo findCabildo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cabildo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCabildoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cabildo> rt = cq.from(Cabildo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
