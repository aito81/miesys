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
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Reunion;

/**
 *
 * @author aito8
 */
public class HanJpaController implements Serializable {

    public HanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Han han) {
        if (han.getPersonaList() == null) {
            han.setPersonaList(new ArrayList<Persona>());
        }
        if (han.getReunionList() == null) {
            han.setReunionList(new ArrayList<Reunion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad ciudad = han.getCiudad();
            if (ciudad != null) {
                ciudad = em.getReference(ciudad.getClass(), ciudad.getCiudad());
                han.setCiudad(ciudad);
            }
            Distrito distrito = han.getDistrito();
            if (distrito != null) {
                distrito = em.getReference(distrito.getClass(), distrito.getDistrito());
                han.setDistrito(distrito);
            }
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : han.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            han.setPersonaList(attachedPersonaList);
            List<Reunion> attachedReunionList = new ArrayList<Reunion>();
            for (Reunion reunionListReunionToAttach : han.getReunionList()) {
                reunionListReunionToAttach = em.getReference(reunionListReunionToAttach.getClass(), reunionListReunionToAttach.getReunion());
                attachedReunionList.add(reunionListReunionToAttach);
            }
            han.setReunionList(attachedReunionList);
            em.persist(han);
            if (ciudad != null) {
                ciudad.getHanList().add(han);
                ciudad = em.merge(ciudad);
            }
            if (distrito != null) {
                distrito.getHanList().add(han);
                distrito = em.merge(distrito);
            }
            for (Persona personaListPersona : han.getPersonaList()) {
                Han oldHanOfPersonaListPersona = personaListPersona.getHan();
                personaListPersona.setHan(han);
                personaListPersona = em.merge(personaListPersona);
                if (oldHanOfPersonaListPersona != null) {
                    oldHanOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldHanOfPersonaListPersona = em.merge(oldHanOfPersonaListPersona);
                }
            }
            for (Reunion reunionListReunion : han.getReunionList()) {
                Han oldHanOfReunionListReunion = reunionListReunion.getHan();
                reunionListReunion.setHan(han);
                reunionListReunion = em.merge(reunionListReunion);
                if (oldHanOfReunionListReunion != null) {
                    oldHanOfReunionListReunion.getReunionList().remove(reunionListReunion);
                    oldHanOfReunionListReunion = em.merge(oldHanOfReunionListReunion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Han han) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Han persistentHan = em.find(Han.class, han.getHan());
            Ciudad ciudadOld = persistentHan.getCiudad();
            Ciudad ciudadNew = han.getCiudad();
            Distrito distritoOld = persistentHan.getDistrito();
            Distrito distritoNew = han.getDistrito();
            List<Persona> personaListOld = persistentHan.getPersonaList();
            List<Persona> personaListNew = han.getPersonaList();
            List<Reunion> reunionListOld = persistentHan.getReunionList();
            List<Reunion> reunionListNew = han.getReunionList();
            List<String> illegalOrphanMessages = null;
            for (Reunion reunionListOldReunion : reunionListOld) {
                if (!reunionListNew.contains(reunionListOldReunion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reunion " + reunionListOldReunion + " since its han field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (ciudadNew != null) {
                ciudadNew = em.getReference(ciudadNew.getClass(), ciudadNew.getCiudad());
                han.setCiudad(ciudadNew);
            }
            if (distritoNew != null) {
                distritoNew = em.getReference(distritoNew.getClass(), distritoNew.getDistrito());
                han.setDistrito(distritoNew);
            }
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            han.setPersonaList(personaListNew);
            List<Reunion> attachedReunionListNew = new ArrayList<Reunion>();
            for (Reunion reunionListNewReunionToAttach : reunionListNew) {
                reunionListNewReunionToAttach = em.getReference(reunionListNewReunionToAttach.getClass(), reunionListNewReunionToAttach.getReunion());
                attachedReunionListNew.add(reunionListNewReunionToAttach);
            }
            reunionListNew = attachedReunionListNew;
            han.setReunionList(reunionListNew);
            han = em.merge(han);
            if (ciudadOld != null && !ciudadOld.equals(ciudadNew)) {
                ciudadOld.getHanList().remove(han);
                ciudadOld = em.merge(ciudadOld);
            }
            if (ciudadNew != null && !ciudadNew.equals(ciudadOld)) {
                ciudadNew.getHanList().add(han);
                ciudadNew = em.merge(ciudadNew);
            }
            if (distritoOld != null && !distritoOld.equals(distritoNew)) {
                distritoOld.getHanList().remove(han);
                distritoOld = em.merge(distritoOld);
            }
            if (distritoNew != null && !distritoNew.equals(distritoOld)) {
                distritoNew.getHanList().add(han);
                distritoNew = em.merge(distritoNew);
            }
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    personaListOldPersona.setHan(null);
                    personaListOldPersona = em.merge(personaListOldPersona);
                }
            }
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    Han oldHanOfPersonaListNewPersona = personaListNewPersona.getHan();
                    personaListNewPersona.setHan(han);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldHanOfPersonaListNewPersona != null && !oldHanOfPersonaListNewPersona.equals(han)) {
                        oldHanOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldHanOfPersonaListNewPersona = em.merge(oldHanOfPersonaListNewPersona);
                    }
                }
            }
            for (Reunion reunionListNewReunion : reunionListNew) {
                if (!reunionListOld.contains(reunionListNewReunion)) {
                    Han oldHanOfReunionListNewReunion = reunionListNewReunion.getHan();
                    reunionListNewReunion.setHan(han);
                    reunionListNewReunion = em.merge(reunionListNewReunion);
                    if (oldHanOfReunionListNewReunion != null && !oldHanOfReunionListNewReunion.equals(han)) {
                        oldHanOfReunionListNewReunion.getReunionList().remove(reunionListNewReunion);
                        oldHanOfReunionListNewReunion = em.merge(oldHanOfReunionListNewReunion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = han.getHan();
                if (findHan(id) == null) {
                    throw new NonexistentEntityException("The han with id " + id + " no longer exists.");
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
            Han han;
            try {
                han = em.getReference(Han.class, id);
                han.getHan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The han with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Reunion> reunionListOrphanCheck = han.getReunionList();
            for (Reunion reunionListOrphanCheckReunion : reunionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Han (" + han + ") cannot be destroyed since the Reunion " + reunionListOrphanCheckReunion + " in its reunionList field has a non-nullable han field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Ciudad ciudad = han.getCiudad();
            if (ciudad != null) {
                ciudad.getHanList().remove(han);
                ciudad = em.merge(ciudad);
            }
            Distrito distrito = han.getDistrito();
            if (distrito != null) {
                distrito.getHanList().remove(han);
                distrito = em.merge(distrito);
            }
            List<Persona> personaList = han.getPersonaList();
            for (Persona personaListPersona : personaList) {
                personaListPersona.setHan(null);
                personaListPersona = em.merge(personaListPersona);
            }
            em.remove(han);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Han> findHanEntities() {
        return findHanEntities(true, -1, -1);
    }

    public List<Han> findHanEntities(int maxResults, int firstResult) {
        return findHanEntities(false, maxResults, firstResult);
    }

    private List<Han> findHanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Han.class));
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

    public Han findHan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Han.class, id);
        } finally {
            em.close();
        }
    }

    public int getHanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Han> rt = cq.from(Han.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
