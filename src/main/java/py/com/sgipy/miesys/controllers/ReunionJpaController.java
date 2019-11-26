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
import py.com.sgipy.miesys.entities.Estudio;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.ReunionAsistencia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Reunion;

/**
 *
 * @author aito8
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
        if (reunion.getReunionAsistenciaList() == null) {
            reunion.setReunionAsistenciaList(new ArrayList<ReunionAsistencia>());
        }
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
            Persona persona = reunion.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getPersona());
                reunion.setPersona(persona);
            }
            List<ReunionAsistencia> attachedReunionAsistenciaList = new ArrayList<ReunionAsistencia>();
            for (ReunionAsistencia reunionAsistenciaListReunionAsistenciaToAttach : reunion.getReunionAsistenciaList()) {
                reunionAsistenciaListReunionAsistenciaToAttach = em.getReference(reunionAsistenciaListReunionAsistenciaToAttach.getClass(), reunionAsistenciaListReunionAsistenciaToAttach.getReunionAsistencia());
                attachedReunionAsistenciaList.add(reunionAsistenciaListReunionAsistenciaToAttach);
            }
            reunion.setReunionAsistenciaList(attachedReunionAsistenciaList);
            em.persist(reunion);
            if (estudio != null) {
                estudio.getReunionList().add(reunion);
                estudio = em.merge(estudio);
            }
            if (han != null) {
                han.getReunionList().add(reunion);
                han = em.merge(han);
            }
            if (persona != null) {
                persona.getReunionList().add(reunion);
                persona = em.merge(persona);
            }
            for (ReunionAsistencia reunionAsistenciaListReunionAsistencia : reunion.getReunionAsistenciaList()) {
                Reunion oldReunionOfReunionAsistenciaListReunionAsistencia = reunionAsistenciaListReunionAsistencia.getReunion();
                reunionAsistenciaListReunionAsistencia.setReunion(reunion);
                reunionAsistenciaListReunionAsistencia = em.merge(reunionAsistenciaListReunionAsistencia);
                if (oldReunionOfReunionAsistenciaListReunionAsistencia != null) {
                    oldReunionOfReunionAsistenciaListReunionAsistencia.getReunionAsistenciaList().remove(reunionAsistenciaListReunionAsistencia);
                    oldReunionOfReunionAsistenciaListReunionAsistencia = em.merge(oldReunionOfReunionAsistenciaListReunionAsistencia);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reunion reunion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reunion persistentReunion = em.find(Reunion.class, reunion.getReunion());
            Estudio estudioOld = persistentReunion.getEstudio();
            Estudio estudioNew = reunion.getEstudio();
            Han hanOld = persistentReunion.getHan();
            Han hanNew = reunion.getHan();
            Persona personaOld = persistentReunion.getPersona();
            Persona personaNew = reunion.getPersona();
            List<ReunionAsistencia> reunionAsistenciaListOld = persistentReunion.getReunionAsistenciaList();
            List<ReunionAsistencia> reunionAsistenciaListNew = reunion.getReunionAsistenciaList();
            List<String> illegalOrphanMessages = null;
            for (ReunionAsistencia reunionAsistenciaListOldReunionAsistencia : reunionAsistenciaListOld) {
                if (!reunionAsistenciaListNew.contains(reunionAsistenciaListOldReunionAsistencia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ReunionAsistencia " + reunionAsistenciaListOldReunionAsistencia + " since its reunion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (estudioNew != null) {
                estudioNew = em.getReference(estudioNew.getClass(), estudioNew.getEstudio());
                reunion.setEstudio(estudioNew);
            }
            if (hanNew != null) {
                hanNew = em.getReference(hanNew.getClass(), hanNew.getHan());
                reunion.setHan(hanNew);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getPersona());
                reunion.setPersona(personaNew);
            }
            List<ReunionAsistencia> attachedReunionAsistenciaListNew = new ArrayList<ReunionAsistencia>();
            for (ReunionAsistencia reunionAsistenciaListNewReunionAsistenciaToAttach : reunionAsistenciaListNew) {
                reunionAsistenciaListNewReunionAsistenciaToAttach = em.getReference(reunionAsistenciaListNewReunionAsistenciaToAttach.getClass(), reunionAsistenciaListNewReunionAsistenciaToAttach.getReunionAsistencia());
                attachedReunionAsistenciaListNew.add(reunionAsistenciaListNewReunionAsistenciaToAttach);
            }
            reunionAsistenciaListNew = attachedReunionAsistenciaListNew;
            reunion.setReunionAsistenciaList(reunionAsistenciaListNew);
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
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.getReunionList().remove(reunion);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.getReunionList().add(reunion);
                personaNew = em.merge(personaNew);
            }
            for (ReunionAsistencia reunionAsistenciaListNewReunionAsistencia : reunionAsistenciaListNew) {
                if (!reunionAsistenciaListOld.contains(reunionAsistenciaListNewReunionAsistencia)) {
                    Reunion oldReunionOfReunionAsistenciaListNewReunionAsistencia = reunionAsistenciaListNewReunionAsistencia.getReunion();
                    reunionAsistenciaListNewReunionAsistencia.setReunion(reunion);
                    reunionAsistenciaListNewReunionAsistencia = em.merge(reunionAsistenciaListNewReunionAsistencia);
                    if (oldReunionOfReunionAsistenciaListNewReunionAsistencia != null && !oldReunionOfReunionAsistenciaListNewReunionAsistencia.equals(reunion)) {
                        oldReunionOfReunionAsistenciaListNewReunionAsistencia.getReunionAsistenciaList().remove(reunionAsistenciaListNewReunionAsistencia);
                        oldReunionOfReunionAsistenciaListNewReunionAsistencia = em.merge(oldReunionOfReunionAsistenciaListNewReunionAsistencia);
                    }
                }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<ReunionAsistencia> reunionAsistenciaListOrphanCheck = reunion.getReunionAsistenciaList();
            for (ReunionAsistencia reunionAsistenciaListOrphanCheckReunionAsistencia : reunionAsistenciaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Reunion (" + reunion + ") cannot be destroyed since the ReunionAsistencia " + reunionAsistenciaListOrphanCheckReunionAsistencia + " in its reunionAsistenciaList field has a non-nullable reunion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
            Persona persona = reunion.getPersona();
            if (persona != null) {
                persona.getReunionList().remove(reunion);
                persona = em.merge(persona);
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
