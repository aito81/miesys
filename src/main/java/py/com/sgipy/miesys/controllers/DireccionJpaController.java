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
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Direccion;
import py.com.sgipy.miesys.entities.Persona;

/**
 *
 * @author aito8
 */
public class DireccionJpaController implements Serializable {

    public DireccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Direccion direccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad ciudad = direccion.getCiudad();
            if (ciudad != null) {
                ciudad = em.getReference(ciudad.getClass(), ciudad.getCiudad());
                direccion.setCiudad(ciudad);
            }
            Persona persona = direccion.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getPersona());
                direccion.setPersona(persona);
            }
            em.persist(direccion);
            if (ciudad != null) {
                ciudad.getDireccionList().add(direccion);
                ciudad = em.merge(ciudad);
            }
            if (persona != null) {
                persona.getDireccionList().add(direccion);
                persona = em.merge(persona);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Direccion direccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Direccion persistentDireccion = em.find(Direccion.class, direccion.getDireccion());
            Ciudad ciudadOld = persistentDireccion.getCiudad();
            Ciudad ciudadNew = direccion.getCiudad();
            Persona personaOld = persistentDireccion.getPersona();
            Persona personaNew = direccion.getPersona();
            if (ciudadNew != null) {
                ciudadNew = em.getReference(ciudadNew.getClass(), ciudadNew.getCiudad());
                direccion.setCiudad(ciudadNew);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getPersona());
                direccion.setPersona(personaNew);
            }
            direccion = em.merge(direccion);
            if (ciudadOld != null && !ciudadOld.equals(ciudadNew)) {
                ciudadOld.getDireccionList().remove(direccion);
                ciudadOld = em.merge(ciudadOld);
            }
            if (ciudadNew != null && !ciudadNew.equals(ciudadOld)) {
                ciudadNew.getDireccionList().add(direccion);
                ciudadNew = em.merge(ciudadNew);
            }
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.getDireccionList().remove(direccion);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.getDireccionList().add(direccion);
                personaNew = em.merge(personaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = direccion.getDireccion();
                if (findDireccion(id) == null) {
                    throw new NonexistentEntityException("The direccion with id " + id + " no longer exists.");
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
            Direccion direccion;
            try {
                direccion = em.getReference(Direccion.class, id);
                direccion.getDireccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The direccion with id " + id + " no longer exists.", enfe);
            }
            Ciudad ciudad = direccion.getCiudad();
            if (ciudad != null) {
                ciudad.getDireccionList().remove(direccion);
                ciudad = em.merge(ciudad);
            }
            Persona persona = direccion.getPersona();
            if (persona != null) {
                persona.getDireccionList().remove(direccion);
                persona = em.merge(persona);
            }
            em.remove(direccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Direccion> findDireccionEntities() {
        return findDireccionEntities(true, -1, -1);
    }

    public List<Direccion> findDireccionEntities(int maxResults, int firstResult) {
        return findDireccionEntities(false, maxResults, firstResult);
    }

    private List<Direccion> findDireccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Direccion.class));
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

    public Direccion findDireccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Direccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDireccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Direccion> rt = cq.from(Direccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
