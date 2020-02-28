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
import py.com.sgipy.miesys.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Tenencia;

/**
 *
 * @author aito8
 */
public class TenenciaJpaController implements Serializable {

    public TenenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tenencia tenencia) {
        if (tenencia.getPersonaList() == null) {
            tenencia.setPersonaList(new ArrayList<Persona>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : tenencia.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            tenencia.setPersonaList(attachedPersonaList);
            em.persist(tenencia);
            for (Persona personaListPersona : tenencia.getPersonaList()) {
                Tenencia oldMiembroConOfPersonaListPersona = personaListPersona.getMiembroCon();
                personaListPersona.setMiembroCon(tenencia);
                personaListPersona = em.merge(personaListPersona);
                if (oldMiembroConOfPersonaListPersona != null) {
                    oldMiembroConOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldMiembroConOfPersonaListPersona = em.merge(oldMiembroConOfPersonaListPersona);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tenencia tenencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tenencia persistentTenencia = em.find(Tenencia.class, tenencia.getTenencia());
            List<Persona> personaListOld = persistentTenencia.getPersonaList();
            List<Persona> personaListNew = tenencia.getPersonaList();
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            tenencia.setPersonaList(personaListNew);
            tenencia = em.merge(tenencia);
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    personaListOldPersona.setMiembroCon(null);
                    personaListOldPersona = em.merge(personaListOldPersona);
                }
            }
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    Tenencia oldMiembroConOfPersonaListNewPersona = personaListNewPersona.getMiembroCon();
                    personaListNewPersona.setMiembroCon(tenencia);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldMiembroConOfPersonaListNewPersona != null && !oldMiembroConOfPersonaListNewPersona.equals(tenencia)) {
                        oldMiembroConOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldMiembroConOfPersonaListNewPersona = em.merge(oldMiembroConOfPersonaListNewPersona);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tenencia.getTenencia();
                if (findTenencia(id) == null) {
                    throw new NonexistentEntityException("The tenencia with id " + id + " no longer exists.");
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
            Tenencia tenencia;
            try {
                tenencia = em.getReference(Tenencia.class, id);
                tenencia.getTenencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tenencia with id " + id + " no longer exists.", enfe);
            }
            List<Persona> personaList = tenencia.getPersonaList();
            for (Persona personaListPersona : personaList) {
                personaListPersona.setMiembroCon(null);
                personaListPersona = em.merge(personaListPersona);
            }
            em.remove(tenencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tenencia> findTenenciaEntities() {
        return findTenenciaEntities(true, -1, -1);
    }

    public List<Tenencia> findTenenciaEntities(int maxResults, int firstResult) {
        return findTenenciaEntities(false, maxResults, firstResult);
    }

    private List<Tenencia> findTenenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tenencia.class));
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

    public Tenencia findTenencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tenencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTenenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tenencia> rt = cq.from(Tenencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
