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
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Direccion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Barrio;
import py.com.sgipy.miesys.entities.Han;

/**
 *
 * @author aito8
 */
public class BarrioJpaController implements Serializable {

    public BarrioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Barrio barrio) {
        if (barrio.getDireccionList() == null) {
            barrio.setDireccionList(new ArrayList<Direccion>());
        }
        if (barrio.getHanList() == null) {
            barrio.setHanList(new ArrayList<Han>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad ciudad = barrio.getCiudad();
            if (ciudad != null) {
                ciudad = em.getReference(ciudad.getClass(), ciudad.getCiudad());
                barrio.setCiudad(ciudad);
            }
            List<Direccion> attachedDireccionList = new ArrayList<Direccion>();
            for (Direccion direccionListDireccionToAttach : barrio.getDireccionList()) {
                direccionListDireccionToAttach = em.getReference(direccionListDireccionToAttach.getClass(), direccionListDireccionToAttach.getDireccion());
                attachedDireccionList.add(direccionListDireccionToAttach);
            }
            barrio.setDireccionList(attachedDireccionList);
            List<Han> attachedHanList = new ArrayList<Han>();
            for (Han hanListHanToAttach : barrio.getHanList()) {
                hanListHanToAttach = em.getReference(hanListHanToAttach.getClass(), hanListHanToAttach.getHan());
                attachedHanList.add(hanListHanToAttach);
            }
            barrio.setHanList(attachedHanList);
            em.persist(barrio);
            if (ciudad != null) {
                ciudad.getBarrioList().add(barrio);
                ciudad = em.merge(ciudad);
            }
            for (Direccion direccionListDireccion : barrio.getDireccionList()) {
                Barrio oldBarrioOfDireccionListDireccion = direccionListDireccion.getBarrio();
                direccionListDireccion.setBarrio(barrio);
                direccionListDireccion = em.merge(direccionListDireccion);
                if (oldBarrioOfDireccionListDireccion != null) {
                    oldBarrioOfDireccionListDireccion.getDireccionList().remove(direccionListDireccion);
                    oldBarrioOfDireccionListDireccion = em.merge(oldBarrioOfDireccionListDireccion);
                }
            }
            for (Han hanListHan : barrio.getHanList()) {
                Barrio oldBarrioOfHanListHan = hanListHan.getBarrio();
                hanListHan.setBarrio(barrio);
                hanListHan = em.merge(hanListHan);
                if (oldBarrioOfHanListHan != null) {
                    oldBarrioOfHanListHan.getHanList().remove(hanListHan);
                    oldBarrioOfHanListHan = em.merge(oldBarrioOfHanListHan);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Barrio barrio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Barrio persistentBarrio = em.find(Barrio.class, barrio.getBarrio());
            Ciudad ciudadOld = persistentBarrio.getCiudad();
            Ciudad ciudadNew = barrio.getCiudad();
            List<Direccion> direccionListOld = persistentBarrio.getDireccionList();
            List<Direccion> direccionListNew = barrio.getDireccionList();
            List<Han> hanListOld = persistentBarrio.getHanList();
            List<Han> hanListNew = barrio.getHanList();
            if (ciudadNew != null) {
                ciudadNew = em.getReference(ciudadNew.getClass(), ciudadNew.getCiudad());
                barrio.setCiudad(ciudadNew);
            }
            List<Direccion> attachedDireccionListNew = new ArrayList<Direccion>();
            for (Direccion direccionListNewDireccionToAttach : direccionListNew) {
                direccionListNewDireccionToAttach = em.getReference(direccionListNewDireccionToAttach.getClass(), direccionListNewDireccionToAttach.getDireccion());
                attachedDireccionListNew.add(direccionListNewDireccionToAttach);
            }
            direccionListNew = attachedDireccionListNew;
            barrio.setDireccionList(direccionListNew);
            List<Han> attachedHanListNew = new ArrayList<Han>();
            for (Han hanListNewHanToAttach : hanListNew) {
                hanListNewHanToAttach = em.getReference(hanListNewHanToAttach.getClass(), hanListNewHanToAttach.getHan());
                attachedHanListNew.add(hanListNewHanToAttach);
            }
            hanListNew = attachedHanListNew;
            barrio.setHanList(hanListNew);
            barrio = em.merge(barrio);
            if (ciudadOld != null && !ciudadOld.equals(ciudadNew)) {
                ciudadOld.getBarrioList().remove(barrio);
                ciudadOld = em.merge(ciudadOld);
            }
            if (ciudadNew != null && !ciudadNew.equals(ciudadOld)) {
                ciudadNew.getBarrioList().add(barrio);
                ciudadNew = em.merge(ciudadNew);
            }
            for (Direccion direccionListOldDireccion : direccionListOld) {
                if (!direccionListNew.contains(direccionListOldDireccion)) {
                    direccionListOldDireccion.setBarrio(null);
                    direccionListOldDireccion = em.merge(direccionListOldDireccion);
                }
            }
            for (Direccion direccionListNewDireccion : direccionListNew) {
                if (!direccionListOld.contains(direccionListNewDireccion)) {
                    Barrio oldBarrioOfDireccionListNewDireccion = direccionListNewDireccion.getBarrio();
                    direccionListNewDireccion.setBarrio(barrio);
                    direccionListNewDireccion = em.merge(direccionListNewDireccion);
                    if (oldBarrioOfDireccionListNewDireccion != null && !oldBarrioOfDireccionListNewDireccion.equals(barrio)) {
                        oldBarrioOfDireccionListNewDireccion.getDireccionList().remove(direccionListNewDireccion);
                        oldBarrioOfDireccionListNewDireccion = em.merge(oldBarrioOfDireccionListNewDireccion);
                    }
                }
            }
            for (Han hanListOldHan : hanListOld) {
                if (!hanListNew.contains(hanListOldHan)) {
                    hanListOldHan.setBarrio(null);
                    hanListOldHan = em.merge(hanListOldHan);
                }
            }
            for (Han hanListNewHan : hanListNew) {
                if (!hanListOld.contains(hanListNewHan)) {
                    Barrio oldBarrioOfHanListNewHan = hanListNewHan.getBarrio();
                    hanListNewHan.setBarrio(barrio);
                    hanListNewHan = em.merge(hanListNewHan);
                    if (oldBarrioOfHanListNewHan != null && !oldBarrioOfHanListNewHan.equals(barrio)) {
                        oldBarrioOfHanListNewHan.getHanList().remove(hanListNewHan);
                        oldBarrioOfHanListNewHan = em.merge(oldBarrioOfHanListNewHan);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = barrio.getBarrio();
                if (findBarrio(id) == null) {
                    throw new NonexistentEntityException("The barrio with id " + id + " no longer exists.");
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
            Barrio barrio;
            try {
                barrio = em.getReference(Barrio.class, id);
                barrio.getBarrio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The barrio with id " + id + " no longer exists.", enfe);
            }
            Ciudad ciudad = barrio.getCiudad();
            if (ciudad != null) {
                ciudad.getBarrioList().remove(barrio);
                ciudad = em.merge(ciudad);
            }
            List<Direccion> direccionList = barrio.getDireccionList();
            for (Direccion direccionListDireccion : direccionList) {
                direccionListDireccion.setBarrio(null);
                direccionListDireccion = em.merge(direccionListDireccion);
            }
            List<Han> hanList = barrio.getHanList();
            for (Han hanListHan : hanList) {
                hanListHan.setBarrio(null);
                hanListHan = em.merge(hanListHan);
            }
            em.remove(barrio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Barrio> findBarrioEntities() {
        return findBarrioEntities(true, -1, -1);
    }

    public List<Barrio> findBarrioEntities(int maxResults, int firstResult) {
        return findBarrioEntities(false, maxResults, firstResult);
    }

    private List<Barrio> findBarrioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Barrio.class));
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

    public Barrio findBarrio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Barrio.class, id);
        } finally {
            em.close();
        }
    }

    public int getBarrioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Barrio> rt = cq.from(Barrio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
