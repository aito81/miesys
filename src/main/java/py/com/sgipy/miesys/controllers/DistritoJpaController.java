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
import py.com.sgipy.miesys.entities.Han;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Distrito;

/**
 *
 * @author Santiago
 */
public class DistritoJpaController implements Serializable {

    public DistritoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Distrito distrito) {
        if (distrito.getHanList() == null) {
            distrito.setHanList(new ArrayList<Han>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cabildo cabildo = distrito.getCabildo();
            if (cabildo != null) {
                cabildo = em.getReference(cabildo.getClass(), cabildo.getCabildo());
                distrito.setCabildo(cabildo);
            }
            List<Han> attachedHanList = new ArrayList<Han>();
            for (Han hanListHanToAttach : distrito.getHanList()) {
                hanListHanToAttach = em.getReference(hanListHanToAttach.getClass(), hanListHanToAttach.getHan());
                attachedHanList.add(hanListHanToAttach);
            }
            distrito.setHanList(attachedHanList);
            em.persist(distrito);
            if (cabildo != null) {
                cabildo.getDistritoList().add(distrito);
                cabildo = em.merge(cabildo);
            }
            for (Han hanListHan : distrito.getHanList()) {
                Distrito oldDistritoOfHanListHan = hanListHan.getDistrito();
                hanListHan.setDistrito(distrito);
                hanListHan = em.merge(hanListHan);
                if (oldDistritoOfHanListHan != null) {
                    oldDistritoOfHanListHan.getHanList().remove(hanListHan);
                    oldDistritoOfHanListHan = em.merge(oldDistritoOfHanListHan);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Distrito distrito) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Distrito persistentDistrito = em.find(Distrito.class, distrito.getDistrito());
            Cabildo cabildoOld = persistentDistrito.getCabildo();
            Cabildo cabildoNew = distrito.getCabildo();
            List<Han> hanListOld = persistentDistrito.getHanList();
            List<Han> hanListNew = distrito.getHanList();
            List<String> illegalOrphanMessages = null;
            for (Han hanListOldHan : hanListOld) {
                if (!hanListNew.contains(hanListOldHan)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Han " + hanListOldHan + " since its distrito field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cabildoNew != null) {
                cabildoNew = em.getReference(cabildoNew.getClass(), cabildoNew.getCabildo());
                distrito.setCabildo(cabildoNew);
            }
            List<Han> attachedHanListNew = new ArrayList<Han>();
            for (Han hanListNewHanToAttach : hanListNew) {
                hanListNewHanToAttach = em.getReference(hanListNewHanToAttach.getClass(), hanListNewHanToAttach.getHan());
                attachedHanListNew.add(hanListNewHanToAttach);
            }
            hanListNew = attachedHanListNew;
            distrito.setHanList(hanListNew);
            distrito = em.merge(distrito);
            if (cabildoOld != null && !cabildoOld.equals(cabildoNew)) {
                cabildoOld.getDistritoList().remove(distrito);
                cabildoOld = em.merge(cabildoOld);
            }
            if (cabildoNew != null && !cabildoNew.equals(cabildoOld)) {
                cabildoNew.getDistritoList().add(distrito);
                cabildoNew = em.merge(cabildoNew);
            }
            for (Han hanListNewHan : hanListNew) {
                if (!hanListOld.contains(hanListNewHan)) {
                    Distrito oldDistritoOfHanListNewHan = hanListNewHan.getDistrito();
                    hanListNewHan.setDistrito(distrito);
                    hanListNewHan = em.merge(hanListNewHan);
                    if (oldDistritoOfHanListNewHan != null && !oldDistritoOfHanListNewHan.equals(distrito)) {
                        oldDistritoOfHanListNewHan.getHanList().remove(hanListNewHan);
                        oldDistritoOfHanListNewHan = em.merge(oldDistritoOfHanListNewHan);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = distrito.getDistrito();
                if (findDistrito(id) == null) {
                    throw new NonexistentEntityException("The distrito with id " + id + " no longer exists.");
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
            Distrito distrito;
            try {
                distrito = em.getReference(Distrito.class, id);
                distrito.getDistrito();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The distrito with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Han> hanListOrphanCheck = distrito.getHanList();
            for (Han hanListOrphanCheckHan : hanListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Distrito (" + distrito + ") cannot be destroyed since the Han " + hanListOrphanCheckHan + " in its hanList field has a non-nullable distrito field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cabildo cabildo = distrito.getCabildo();
            if (cabildo != null) {
                cabildo.getDistritoList().remove(distrito);
                cabildo = em.merge(cabildo);
            }
            em.remove(distrito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Distrito> findDistritoEntities() {
        return findDistritoEntities(true, -1, -1);
    }

    public List<Distrito> findDistritoEntities(int maxResults, int firstResult) {
        return findDistritoEntities(false, maxResults, firstResult);
    }

    private List<Distrito> findDistritoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Distrito.class));
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

    public Distrito findDistrito(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Distrito.class, id);
        } finally {
            em.close();
        }
    }

    public int getDistritoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Distrito> rt = cq.from(Distrito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
