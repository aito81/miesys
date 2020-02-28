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
import py.com.sgipy.miesys.entities.Cabildo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Region;

/**
 *
 * @author aito8
 */
public class RegionJpaController implements Serializable {

    public RegionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Region region) {
        if (region.getCabildoList() == null) {
            region.setCabildoList(new ArrayList<Cabildo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cabildo> attachedCabildoList = new ArrayList<Cabildo>();
            for (Cabildo cabildoListCabildoToAttach : region.getCabildoList()) {
                cabildoListCabildoToAttach = em.getReference(cabildoListCabildoToAttach.getClass(), cabildoListCabildoToAttach.getCabildo());
                attachedCabildoList.add(cabildoListCabildoToAttach);
            }
            region.setCabildoList(attachedCabildoList);
            em.persist(region);
            for (Cabildo cabildoListCabildo : region.getCabildoList()) {
                Region oldRegionOfCabildoListCabildo = cabildoListCabildo.getRegion();
                cabildoListCabildo.setRegion(region);
                cabildoListCabildo = em.merge(cabildoListCabildo);
                if (oldRegionOfCabildoListCabildo != null) {
                    oldRegionOfCabildoListCabildo.getCabildoList().remove(cabildoListCabildo);
                    oldRegionOfCabildoListCabildo = em.merge(oldRegionOfCabildoListCabildo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Region region) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Region persistentRegion = em.find(Region.class, region.getRegion());
            List<Cabildo> cabildoListOld = persistentRegion.getCabildoList();
            List<Cabildo> cabildoListNew = region.getCabildoList();
            List<String> illegalOrphanMessages = null;
            for (Cabildo cabildoListOldCabildo : cabildoListOld) {
                if (!cabildoListNew.contains(cabildoListOldCabildo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cabildo " + cabildoListOldCabildo + " since its region field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Cabildo> attachedCabildoListNew = new ArrayList<Cabildo>();
            for (Cabildo cabildoListNewCabildoToAttach : cabildoListNew) {
                cabildoListNewCabildoToAttach = em.getReference(cabildoListNewCabildoToAttach.getClass(), cabildoListNewCabildoToAttach.getCabildo());
                attachedCabildoListNew.add(cabildoListNewCabildoToAttach);
            }
            cabildoListNew = attachedCabildoListNew;
            region.setCabildoList(cabildoListNew);
            region = em.merge(region);
            for (Cabildo cabildoListNewCabildo : cabildoListNew) {
                if (!cabildoListOld.contains(cabildoListNewCabildo)) {
                    Region oldRegionOfCabildoListNewCabildo = cabildoListNewCabildo.getRegion();
                    cabildoListNewCabildo.setRegion(region);
                    cabildoListNewCabildo = em.merge(cabildoListNewCabildo);
                    if (oldRegionOfCabildoListNewCabildo != null && !oldRegionOfCabildoListNewCabildo.equals(region)) {
                        oldRegionOfCabildoListNewCabildo.getCabildoList().remove(cabildoListNewCabildo);
                        oldRegionOfCabildoListNewCabildo = em.merge(oldRegionOfCabildoListNewCabildo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = region.getRegion();
                if (findRegion(id) == null) {
                    throw new NonexistentEntityException("The region with id " + id + " no longer exists.");
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
            Region region;
            try {
                region = em.getReference(Region.class, id);
                region.getRegion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The region with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cabildo> cabildoListOrphanCheck = region.getCabildoList();
            for (Cabildo cabildoListOrphanCheckCabildo : cabildoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Region (" + region + ") cannot be destroyed since the Cabildo " + cabildoListOrphanCheckCabildo + " in its cabildoList field has a non-nullable region field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(region);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Region> findRegionEntities() {
        return findRegionEntities(true, -1, -1);
    }

    public List<Region> findRegionEntities(int maxResults, int firstResult) {
        return findRegionEntities(false, maxResults, firstResult);
    }

    private List<Region> findRegionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Region.class));
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

    public Region findRegion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Region.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Region> rt = cq.from(Region.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
