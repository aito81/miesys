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
import py.com.sgipy.miesys.entities.Recomendado;

/**
 *
 * @author aito8
 */
public class RecomendadoJpaController implements Serializable {

    public RecomendadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recomendado recomendado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona = recomendado.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getPersona());
                recomendado.setPersona(persona);
            }
            Persona recomendador1 = recomendado.getRecomendador1();
            if (recomendador1 != null) {
                recomendador1 = em.getReference(recomendador1.getClass(), recomendador1.getPersona());
                recomendado.setRecomendador1(recomendador1);
            }
            Persona recomendador2 = recomendado.getRecomendador2();
            if (recomendador2 != null) {
                recomendador2 = em.getReference(recomendador2.getClass(), recomendador2.getPersona());
                recomendado.setRecomendador2(recomendador2);
            }
            em.persist(recomendado);
            if (persona != null) {
                persona.getRecomendadoList().add(recomendado);
                persona = em.merge(persona);
            }
            if (recomendador1 != null) {
                recomendador1.getRecomendadoList().add(recomendado);
                recomendador1 = em.merge(recomendador1);
            }
            if (recomendador2 != null) {
                recomendador2.getRecomendadoList().add(recomendado);
                recomendador2 = em.merge(recomendador2);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recomendado recomendado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recomendado persistentRecomendado = em.find(Recomendado.class, recomendado.getRecomendado());
            Persona personaOld = persistentRecomendado.getPersona();
            Persona personaNew = recomendado.getPersona();
            Persona recomendador1Old = persistentRecomendado.getRecomendador1();
            Persona recomendador1New = recomendado.getRecomendador1();
            Persona recomendador2Old = persistentRecomendado.getRecomendador2();
            Persona recomendador2New = recomendado.getRecomendador2();
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getPersona());
                recomendado.setPersona(personaNew);
            }
            if (recomendador1New != null) {
                recomendador1New = em.getReference(recomendador1New.getClass(), recomendador1New.getPersona());
                recomendado.setRecomendador1(recomendador1New);
            }
            if (recomendador2New != null) {
                recomendador2New = em.getReference(recomendador2New.getClass(), recomendador2New.getPersona());
                recomendado.setRecomendador2(recomendador2New);
            }
            recomendado = em.merge(recomendado);
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.getRecomendadoList().remove(recomendado);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.getRecomendadoList().add(recomendado);
                personaNew = em.merge(personaNew);
            }
            if (recomendador1Old != null && !recomendador1Old.equals(recomendador1New)) {
                recomendador1Old.getRecomendadoList().remove(recomendado);
                recomendador1Old = em.merge(recomendador1Old);
            }
            if (recomendador1New != null && !recomendador1New.equals(recomendador1Old)) {
                recomendador1New.getRecomendadoList().add(recomendado);
                recomendador1New = em.merge(recomendador1New);
            }
            if (recomendador2Old != null && !recomendador2Old.equals(recomendador2New)) {
                recomendador2Old.getRecomendadoList().remove(recomendado);
                recomendador2Old = em.merge(recomendador2Old);
            }
            if (recomendador2New != null && !recomendador2New.equals(recomendador2Old)) {
                recomendador2New.getRecomendadoList().add(recomendado);
                recomendador2New = em.merge(recomendador2New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = recomendado.getRecomendado();
                if (findRecomendado(id) == null) {
                    throw new NonexistentEntityException("The recomendado with id " + id + " no longer exists.");
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
            Recomendado recomendado;
            try {
                recomendado = em.getReference(Recomendado.class, id);
                recomendado.getRecomendado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recomendado with id " + id + " no longer exists.", enfe);
            }
            Persona persona = recomendado.getPersona();
            if (persona != null) {
                persona.getRecomendadoList().remove(recomendado);
                persona = em.merge(persona);
            }
            Persona recomendador1 = recomendado.getRecomendador1();
            if (recomendador1 != null) {
                recomendador1.getRecomendadoList().remove(recomendado);
                recomendador1 = em.merge(recomendador1);
            }
            Persona recomendador2 = recomendado.getRecomendador2();
            if (recomendador2 != null) {
                recomendador2.getRecomendadoList().remove(recomendado);
                recomendador2 = em.merge(recomendador2);
            }
            em.remove(recomendado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recomendado> findRecomendadoEntities() {
        return findRecomendadoEntities(true, -1, -1);
    }

    public List<Recomendado> findRecomendadoEntities(int maxResults, int firstResult) {
        return findRecomendadoEntities(false, maxResults, firstResult);
    }

    private List<Recomendado> findRecomendadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recomendado.class));
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

    public Recomendado findRecomendado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recomendado.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecomendadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recomendado> rt = cq.from(Recomendado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
