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
import py.com.sgipy.miesys.entities.Division;
import py.com.sgipy.miesys.entities.Empresa;
import py.com.sgipy.miesys.entities.EstadoCivil;
import py.com.sgipy.miesys.entities.Genero;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Nacionalidad;
import py.com.sgipy.miesys.entities.Ocupacion;
import py.com.sgipy.miesys.entities.Tenencia;
import py.com.sgipy.miesys.entities.TipoDocumento;
import py.com.sgipy.miesys.entities.Direccion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.ReunionAsistencia;
import py.com.sgipy.miesys.entities.Recomendado;
import py.com.sgipy.miesys.entities.Reunion;
import py.com.sgipy.miesys.entities.Usuario;
import py.com.sgipy.miesys.entities.Telefono;

/**
 *
 * @author aito8
 */
public class PersonaJpaController implements Serializable {

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) {
        if (persona.getDireccionList() == null) {
            persona.setDireccionList(new ArrayList<Direccion>());
        }
        if (persona.getReunionAsistenciaList() == null) {
            persona.setReunionAsistenciaList(new ArrayList<ReunionAsistencia>());
        }
        if (persona.getRecomendadoList() == null) {
            persona.setRecomendadoList(new ArrayList<Recomendado>());
        }
        if (persona.getRecomendadoList1() == null) {
            persona.setRecomendadoList1(new ArrayList<Recomendado>());
        }
        if (persona.getRecomendadoList2() == null) {
            persona.setRecomendadoList2(new ArrayList<Recomendado>());
        }
        if (persona.getReunionList() == null) {
            persona.setReunionList(new ArrayList<Reunion>());
        }
        if (persona.getUsuarioList() == null) {
            persona.setUsuarioList(new ArrayList<Usuario>());
        }
        if (persona.getTelefonoList() == null) {
            persona.setTelefonoList(new ArrayList<Telefono>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Division division = persona.getDivision();
            if (division != null) {
                division = em.getReference(division.getClass(), division.getDivision());
                persona.setDivision(division);
            }
            Empresa empresa = persona.getEmpresa();
            if (empresa != null) {
                empresa = em.getReference(empresa.getClass(), empresa.getEmpresa());
                persona.setEmpresa(empresa);
            }
            EstadoCivil estadoCivil = persona.getEstadoCivil();
            if (estadoCivil != null) {
                estadoCivil = em.getReference(estadoCivil.getClass(), estadoCivil.getEstadoCivil());
                persona.setEstadoCivil(estadoCivil);
            }
            Genero genero = persona.getGenero();
            if (genero != null) {
                genero = em.getReference(genero.getClass(), genero.getGenero());
                persona.setGenero(genero);
            }
            Han han = persona.getHan();
            if (han != null) {
                han = em.getReference(han.getClass(), han.getHan());
                persona.setHan(han);
            }
            Nacionalidad nacionalidad = persona.getNacionalidad();
            if (nacionalidad != null) {
                nacionalidad = em.getReference(nacionalidad.getClass(), nacionalidad.getNacionalidad());
                persona.setNacionalidad(nacionalidad);
            }
            Ocupacion ocupacion = persona.getOcupacion();
            if (ocupacion != null) {
                ocupacion = em.getReference(ocupacion.getClass(), ocupacion.getOcupacion());
                persona.setOcupacion(ocupacion);
            }
            Tenencia miembroCon = persona.getMiembroCon();
            if (miembroCon != null) {
                miembroCon = em.getReference(miembroCon.getClass(), miembroCon.getTenencia());
                persona.setMiembroCon(miembroCon);
            }
            TipoDocumento tipoDocumento = persona.getTipoDocumento();
            if (tipoDocumento != null) {
                tipoDocumento = em.getReference(tipoDocumento.getClass(), tipoDocumento.getTipoDocumento());
                persona.setTipoDocumento(tipoDocumento);
            }
            List<Direccion> attachedDireccionList = new ArrayList<Direccion>();
            for (Direccion direccionListDireccionToAttach : persona.getDireccionList()) {
                direccionListDireccionToAttach = em.getReference(direccionListDireccionToAttach.getClass(), direccionListDireccionToAttach.getDireccion());
                attachedDireccionList.add(direccionListDireccionToAttach);
            }
            persona.setDireccionList(attachedDireccionList);
            List<ReunionAsistencia> attachedReunionAsistenciaList = new ArrayList<ReunionAsistencia>();
            for (ReunionAsistencia reunionAsistenciaListReunionAsistenciaToAttach : persona.getReunionAsistenciaList()) {
                reunionAsistenciaListReunionAsistenciaToAttach = em.getReference(reunionAsistenciaListReunionAsistenciaToAttach.getClass(), reunionAsistenciaListReunionAsistenciaToAttach.getReunionAsistencia());
                attachedReunionAsistenciaList.add(reunionAsistenciaListReunionAsistenciaToAttach);
            }
            persona.setReunionAsistenciaList(attachedReunionAsistenciaList);
            List<Recomendado> attachedRecomendadoList = new ArrayList<Recomendado>();
            for (Recomendado recomendadoListRecomendadoToAttach : persona.getRecomendadoList()) {
                recomendadoListRecomendadoToAttach = em.getReference(recomendadoListRecomendadoToAttach.getClass(), recomendadoListRecomendadoToAttach.getRecomendado());
                attachedRecomendadoList.add(recomendadoListRecomendadoToAttach);
            }
            persona.setRecomendadoList(attachedRecomendadoList);
            List<Recomendado> attachedRecomendadoList1 = new ArrayList<Recomendado>();
            for (Recomendado recomendadoList1RecomendadoToAttach : persona.getRecomendadoList1()) {
                recomendadoList1RecomendadoToAttach = em.getReference(recomendadoList1RecomendadoToAttach.getClass(), recomendadoList1RecomendadoToAttach.getRecomendado());
                attachedRecomendadoList1.add(recomendadoList1RecomendadoToAttach);
            }
            persona.setRecomendadoList1(attachedRecomendadoList1);
            List<Recomendado> attachedRecomendadoList2 = new ArrayList<Recomendado>();
            for (Recomendado recomendadoList2RecomendadoToAttach : persona.getRecomendadoList2()) {
                recomendadoList2RecomendadoToAttach = em.getReference(recomendadoList2RecomendadoToAttach.getClass(), recomendadoList2RecomendadoToAttach.getRecomendado());
                attachedRecomendadoList2.add(recomendadoList2RecomendadoToAttach);
            }
            persona.setRecomendadoList2(attachedRecomendadoList2);
            List<Reunion> attachedReunionList = new ArrayList<Reunion>();
            for (Reunion reunionListReunionToAttach : persona.getReunionList()) {
                reunionListReunionToAttach = em.getReference(reunionListReunionToAttach.getClass(), reunionListReunionToAttach.getReunion());
                attachedReunionList.add(reunionListReunionToAttach);
            }
            persona.setReunionList(attachedReunionList);
            List<Usuario> attachedUsuarioList = new ArrayList<Usuario>();
            for (Usuario usuarioListUsuarioToAttach : persona.getUsuarioList()) {
                usuarioListUsuarioToAttach = em.getReference(usuarioListUsuarioToAttach.getClass(), usuarioListUsuarioToAttach.getUsuario());
                attachedUsuarioList.add(usuarioListUsuarioToAttach);
            }
            persona.setUsuarioList(attachedUsuarioList);
            List<Telefono> attachedTelefonoList = new ArrayList<Telefono>();
            for (Telefono telefonoListTelefonoToAttach : persona.getTelefonoList()) {
                telefonoListTelefonoToAttach = em.getReference(telefonoListTelefonoToAttach.getClass(), telefonoListTelefonoToAttach.getTelefono());
                attachedTelefonoList.add(telefonoListTelefonoToAttach);
            }
            persona.setTelefonoList(attachedTelefonoList);
            em.persist(persona);
            if (division != null) {
                division.getPersonaList().add(persona);
                division = em.merge(division);
            }
            if (empresa != null) {
                empresa.getPersonaList().add(persona);
                empresa = em.merge(empresa);
            }
            if (estadoCivil != null) {
                estadoCivil.getPersonaList().add(persona);
                estadoCivil = em.merge(estadoCivil);
            }
            if (genero != null) {
                genero.getPersonaList().add(persona);
                genero = em.merge(genero);
            }
            if (han != null) {
                han.getPersonaList().add(persona);
                han = em.merge(han);
            }
            if (nacionalidad != null) {
                nacionalidad.getPersonaList().add(persona);
                nacionalidad = em.merge(nacionalidad);
            }
            if (ocupacion != null) {
                ocupacion.getPersonaList().add(persona);
                ocupacion = em.merge(ocupacion);
            }
            if (miembroCon != null) {
                miembroCon.getPersonaList().add(persona);
                miembroCon = em.merge(miembroCon);
            }
            if (tipoDocumento != null) {
                tipoDocumento.getPersonaList().add(persona);
                tipoDocumento = em.merge(tipoDocumento);
            }
            for (Direccion direccionListDireccion : persona.getDireccionList()) {
                Persona oldPersonaOfDireccionListDireccion = direccionListDireccion.getPersona();
                direccionListDireccion.setPersona(persona);
                direccionListDireccion = em.merge(direccionListDireccion);
                if (oldPersonaOfDireccionListDireccion != null) {
                    oldPersonaOfDireccionListDireccion.getDireccionList().remove(direccionListDireccion);
                    oldPersonaOfDireccionListDireccion = em.merge(oldPersonaOfDireccionListDireccion);
                }
            }
            for (ReunionAsistencia reunionAsistenciaListReunionAsistencia : persona.getReunionAsistenciaList()) {
                Persona oldPersonaOfReunionAsistenciaListReunionAsistencia = reunionAsistenciaListReunionAsistencia.getPersona();
                reunionAsistenciaListReunionAsistencia.setPersona(persona);
                reunionAsistenciaListReunionAsistencia = em.merge(reunionAsistenciaListReunionAsistencia);
                if (oldPersonaOfReunionAsistenciaListReunionAsistencia != null) {
                    oldPersonaOfReunionAsistenciaListReunionAsistencia.getReunionAsistenciaList().remove(reunionAsistenciaListReunionAsistencia);
                    oldPersonaOfReunionAsistenciaListReunionAsistencia = em.merge(oldPersonaOfReunionAsistenciaListReunionAsistencia);
                }
            }
            for (Recomendado recomendadoListRecomendado : persona.getRecomendadoList()) {
                Persona oldPersonaOfRecomendadoListRecomendado = recomendadoListRecomendado.getPersona();
                recomendadoListRecomendado.setPersona(persona);
                recomendadoListRecomendado = em.merge(recomendadoListRecomendado);
                if (oldPersonaOfRecomendadoListRecomendado != null) {
                    oldPersonaOfRecomendadoListRecomendado.getRecomendadoList().remove(recomendadoListRecomendado);
                    oldPersonaOfRecomendadoListRecomendado = em.merge(oldPersonaOfRecomendadoListRecomendado);
                }
            }
            for (Recomendado recomendadoList1Recomendado : persona.getRecomendadoList1()) {
                Persona oldRecomendador1OfRecomendadoList1Recomendado = recomendadoList1Recomendado.getRecomendador1();
                recomendadoList1Recomendado.setRecomendador1(persona);
                recomendadoList1Recomendado = em.merge(recomendadoList1Recomendado);
                if (oldRecomendador1OfRecomendadoList1Recomendado != null) {
                    oldRecomendador1OfRecomendadoList1Recomendado.getRecomendadoList1().remove(recomendadoList1Recomendado);
                    oldRecomendador1OfRecomendadoList1Recomendado = em.merge(oldRecomendador1OfRecomendadoList1Recomendado);
                }
            }
            for (Recomendado recomendadoList2Recomendado : persona.getRecomendadoList2()) {
                Persona oldRecomendador2OfRecomendadoList2Recomendado = recomendadoList2Recomendado.getRecomendador2();
                recomendadoList2Recomendado.setRecomendador2(persona);
                recomendadoList2Recomendado = em.merge(recomendadoList2Recomendado);
                if (oldRecomendador2OfRecomendadoList2Recomendado != null) {
                    oldRecomendador2OfRecomendadoList2Recomendado.getRecomendadoList2().remove(recomendadoList2Recomendado);
                    oldRecomendador2OfRecomendadoList2Recomendado = em.merge(oldRecomendador2OfRecomendadoList2Recomendado);
                }
            }
            for (Reunion reunionListReunion : persona.getReunionList()) {
                Persona oldPersonaOfReunionListReunion = reunionListReunion.getPersona();
                reunionListReunion.setPersona(persona);
                reunionListReunion = em.merge(reunionListReunion);
                if (oldPersonaOfReunionListReunion != null) {
                    oldPersonaOfReunionListReunion.getReunionList().remove(reunionListReunion);
                    oldPersonaOfReunionListReunion = em.merge(oldPersonaOfReunionListReunion);
                }
            }
            for (Usuario usuarioListUsuario : persona.getUsuarioList()) {
                Persona oldPersonaOfUsuarioListUsuario = usuarioListUsuario.getPersona();
                usuarioListUsuario.setPersona(persona);
                usuarioListUsuario = em.merge(usuarioListUsuario);
                if (oldPersonaOfUsuarioListUsuario != null) {
                    oldPersonaOfUsuarioListUsuario.getUsuarioList().remove(usuarioListUsuario);
                    oldPersonaOfUsuarioListUsuario = em.merge(oldPersonaOfUsuarioListUsuario);
                }
            }
            for (Telefono telefonoListTelefono : persona.getTelefonoList()) {
                Persona oldPersonaOfTelefonoListTelefono = telefonoListTelefono.getPersona();
                telefonoListTelefono.setPersona(persona);
                telefonoListTelefono = em.merge(telefonoListTelefono);
                if (oldPersonaOfTelefonoListTelefono != null) {
                    oldPersonaOfTelefonoListTelefono.getTelefonoList().remove(telefonoListTelefono);
                    oldPersonaOfTelefonoListTelefono = em.merge(oldPersonaOfTelefonoListTelefono);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getPersona());
            Division divisionOld = persistentPersona.getDivision();
            Division divisionNew = persona.getDivision();
            Empresa empresaOld = persistentPersona.getEmpresa();
            Empresa empresaNew = persona.getEmpresa();
            EstadoCivil estadoCivilOld = persistentPersona.getEstadoCivil();
            EstadoCivil estadoCivilNew = persona.getEstadoCivil();
            Genero generoOld = persistentPersona.getGenero();
            Genero generoNew = persona.getGenero();
            Han hanOld = persistentPersona.getHan();
            Han hanNew = persona.getHan();
            Nacionalidad nacionalidadOld = persistentPersona.getNacionalidad();
            Nacionalidad nacionalidadNew = persona.getNacionalidad();
            Ocupacion ocupacionOld = persistentPersona.getOcupacion();
            Ocupacion ocupacionNew = persona.getOcupacion();
            Tenencia miembroConOld = persistentPersona.getMiembroCon();
            Tenencia miembroConNew = persona.getMiembroCon();
            TipoDocumento tipoDocumentoOld = persistentPersona.getTipoDocumento();
            TipoDocumento tipoDocumentoNew = persona.getTipoDocumento();
            List<Direccion> direccionListOld = persistentPersona.getDireccionList();
            List<Direccion> direccionListNew = persona.getDireccionList();
            List<ReunionAsistencia> reunionAsistenciaListOld = persistentPersona.getReunionAsistenciaList();
            List<ReunionAsistencia> reunionAsistenciaListNew = persona.getReunionAsistenciaList();
            List<Recomendado> recomendadoListOld = persistentPersona.getRecomendadoList();
            List<Recomendado> recomendadoListNew = persona.getRecomendadoList();
            List<Recomendado> recomendadoList1Old = persistentPersona.getRecomendadoList1();
            List<Recomendado> recomendadoList1New = persona.getRecomendadoList1();
            List<Recomendado> recomendadoList2Old = persistentPersona.getRecomendadoList2();
            List<Recomendado> recomendadoList2New = persona.getRecomendadoList2();
            List<Reunion> reunionListOld = persistentPersona.getReunionList();
            List<Reunion> reunionListNew = persona.getReunionList();
            List<Usuario> usuarioListOld = persistentPersona.getUsuarioList();
            List<Usuario> usuarioListNew = persona.getUsuarioList();
            List<Telefono> telefonoListOld = persistentPersona.getTelefonoList();
            List<Telefono> telefonoListNew = persona.getTelefonoList();
            List<String> illegalOrphanMessages = null;
            for (Direccion direccionListOldDireccion : direccionListOld) {
                if (!direccionListNew.contains(direccionListOldDireccion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Direccion " + direccionListOldDireccion + " since its persona field is not nullable.");
                }
            }
            for (ReunionAsistencia reunionAsistenciaListOldReunionAsistencia : reunionAsistenciaListOld) {
                if (!reunionAsistenciaListNew.contains(reunionAsistenciaListOldReunionAsistencia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ReunionAsistencia " + reunionAsistenciaListOldReunionAsistencia + " since its persona field is not nullable.");
                }
            }
            for (Recomendado recomendadoListOldRecomendado : recomendadoListOld) {
                if (!recomendadoListNew.contains(recomendadoListOldRecomendado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Recomendado " + recomendadoListOldRecomendado + " since its persona field is not nullable.");
                }
            }
            for (Usuario usuarioListOldUsuario : usuarioListOld) {
                if (!usuarioListNew.contains(usuarioListOldUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuario " + usuarioListOldUsuario + " since its persona field is not nullable.");
                }
            }
            for (Telefono telefonoListOldTelefono : telefonoListOld) {
                if (!telefonoListNew.contains(telefonoListOldTelefono)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Telefono " + telefonoListOldTelefono + " since its persona field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (divisionNew != null) {
                divisionNew = em.getReference(divisionNew.getClass(), divisionNew.getDivision());
                persona.setDivision(divisionNew);
            }
            if (empresaNew != null) {
                empresaNew = em.getReference(empresaNew.getClass(), empresaNew.getEmpresa());
                persona.setEmpresa(empresaNew);
            }
            if (estadoCivilNew != null) {
                estadoCivilNew = em.getReference(estadoCivilNew.getClass(), estadoCivilNew.getEstadoCivil());
                persona.setEstadoCivil(estadoCivilNew);
            }
            if (generoNew != null) {
                generoNew = em.getReference(generoNew.getClass(), generoNew.getGenero());
                persona.setGenero(generoNew);
            }
            if (hanNew != null) {
                hanNew = em.getReference(hanNew.getClass(), hanNew.getHan());
                persona.setHan(hanNew);
            }
            if (nacionalidadNew != null) {
                nacionalidadNew = em.getReference(nacionalidadNew.getClass(), nacionalidadNew.getNacionalidad());
                persona.setNacionalidad(nacionalidadNew);
            }
            if (ocupacionNew != null) {
                ocupacionNew = em.getReference(ocupacionNew.getClass(), ocupacionNew.getOcupacion());
                persona.setOcupacion(ocupacionNew);
            }
            if (miembroConNew != null) {
                miembroConNew = em.getReference(miembroConNew.getClass(), miembroConNew.getTenencia());
                persona.setMiembroCon(miembroConNew);
            }
            if (tipoDocumentoNew != null) {
                tipoDocumentoNew = em.getReference(tipoDocumentoNew.getClass(), tipoDocumentoNew.getTipoDocumento());
                persona.setTipoDocumento(tipoDocumentoNew);
            }
            List<Direccion> attachedDireccionListNew = new ArrayList<Direccion>();
            for (Direccion direccionListNewDireccionToAttach : direccionListNew) {
                direccionListNewDireccionToAttach = em.getReference(direccionListNewDireccionToAttach.getClass(), direccionListNewDireccionToAttach.getDireccion());
                attachedDireccionListNew.add(direccionListNewDireccionToAttach);
            }
            direccionListNew = attachedDireccionListNew;
            persona.setDireccionList(direccionListNew);
            List<ReunionAsistencia> attachedReunionAsistenciaListNew = new ArrayList<ReunionAsistencia>();
            for (ReunionAsistencia reunionAsistenciaListNewReunionAsistenciaToAttach : reunionAsistenciaListNew) {
                reunionAsistenciaListNewReunionAsistenciaToAttach = em.getReference(reunionAsistenciaListNewReunionAsistenciaToAttach.getClass(), reunionAsistenciaListNewReunionAsistenciaToAttach.getReunionAsistencia());
                attachedReunionAsistenciaListNew.add(reunionAsistenciaListNewReunionAsistenciaToAttach);
            }
            reunionAsistenciaListNew = attachedReunionAsistenciaListNew;
            persona.setReunionAsistenciaList(reunionAsistenciaListNew);
            List<Recomendado> attachedRecomendadoListNew = new ArrayList<Recomendado>();
            for (Recomendado recomendadoListNewRecomendadoToAttach : recomendadoListNew) {
                recomendadoListNewRecomendadoToAttach = em.getReference(recomendadoListNewRecomendadoToAttach.getClass(), recomendadoListNewRecomendadoToAttach.getRecomendado());
                attachedRecomendadoListNew.add(recomendadoListNewRecomendadoToAttach);
            }
            recomendadoListNew = attachedRecomendadoListNew;
            persona.setRecomendadoList(recomendadoListNew);
            List<Recomendado> attachedRecomendadoList1New = new ArrayList<Recomendado>();
            for (Recomendado recomendadoList1NewRecomendadoToAttach : recomendadoList1New) {
                recomendadoList1NewRecomendadoToAttach = em.getReference(recomendadoList1NewRecomendadoToAttach.getClass(), recomendadoList1NewRecomendadoToAttach.getRecomendado());
                attachedRecomendadoList1New.add(recomendadoList1NewRecomendadoToAttach);
            }
            recomendadoList1New = attachedRecomendadoList1New;
            persona.setRecomendadoList1(recomendadoList1New);
            List<Recomendado> attachedRecomendadoList2New = new ArrayList<Recomendado>();
            for (Recomendado recomendadoList2NewRecomendadoToAttach : recomendadoList2New) {
                recomendadoList2NewRecomendadoToAttach = em.getReference(recomendadoList2NewRecomendadoToAttach.getClass(), recomendadoList2NewRecomendadoToAttach.getRecomendado());
                attachedRecomendadoList2New.add(recomendadoList2NewRecomendadoToAttach);
            }
            recomendadoList2New = attachedRecomendadoList2New;
            persona.setRecomendadoList2(recomendadoList2New);
            List<Reunion> attachedReunionListNew = new ArrayList<Reunion>();
            for (Reunion reunionListNewReunionToAttach : reunionListNew) {
                reunionListNewReunionToAttach = em.getReference(reunionListNewReunionToAttach.getClass(), reunionListNewReunionToAttach.getReunion());
                attachedReunionListNew.add(reunionListNewReunionToAttach);
            }
            reunionListNew = attachedReunionListNew;
            persona.setReunionList(reunionListNew);
            List<Usuario> attachedUsuarioListNew = new ArrayList<Usuario>();
            for (Usuario usuarioListNewUsuarioToAttach : usuarioListNew) {
                usuarioListNewUsuarioToAttach = em.getReference(usuarioListNewUsuarioToAttach.getClass(), usuarioListNewUsuarioToAttach.getUsuario());
                attachedUsuarioListNew.add(usuarioListNewUsuarioToAttach);
            }
            usuarioListNew = attachedUsuarioListNew;
            persona.setUsuarioList(usuarioListNew);
            List<Telefono> attachedTelefonoListNew = new ArrayList<Telefono>();
            for (Telefono telefonoListNewTelefonoToAttach : telefonoListNew) {
                telefonoListNewTelefonoToAttach = em.getReference(telefonoListNewTelefonoToAttach.getClass(), telefonoListNewTelefonoToAttach.getTelefono());
                attachedTelefonoListNew.add(telefonoListNewTelefonoToAttach);
            }
            telefonoListNew = attachedTelefonoListNew;
            persona.setTelefonoList(telefonoListNew);
            persona = em.merge(persona);
            if (divisionOld != null && !divisionOld.equals(divisionNew)) {
                divisionOld.getPersonaList().remove(persona);
                divisionOld = em.merge(divisionOld);
            }
            if (divisionNew != null && !divisionNew.equals(divisionOld)) {
                divisionNew.getPersonaList().add(persona);
                divisionNew = em.merge(divisionNew);
            }
            if (empresaOld != null && !empresaOld.equals(empresaNew)) {
                empresaOld.getPersonaList().remove(persona);
                empresaOld = em.merge(empresaOld);
            }
            if (empresaNew != null && !empresaNew.equals(empresaOld)) {
                empresaNew.getPersonaList().add(persona);
                empresaNew = em.merge(empresaNew);
            }
            if (estadoCivilOld != null && !estadoCivilOld.equals(estadoCivilNew)) {
                estadoCivilOld.getPersonaList().remove(persona);
                estadoCivilOld = em.merge(estadoCivilOld);
            }
            if (estadoCivilNew != null && !estadoCivilNew.equals(estadoCivilOld)) {
                estadoCivilNew.getPersonaList().add(persona);
                estadoCivilNew = em.merge(estadoCivilNew);
            }
            if (generoOld != null && !generoOld.equals(generoNew)) {
                generoOld.getPersonaList().remove(persona);
                generoOld = em.merge(generoOld);
            }
            if (generoNew != null && !generoNew.equals(generoOld)) {
                generoNew.getPersonaList().add(persona);
                generoNew = em.merge(generoNew);
            }
            if (hanOld != null && !hanOld.equals(hanNew)) {
                hanOld.getPersonaList().remove(persona);
                hanOld = em.merge(hanOld);
            }
            if (hanNew != null && !hanNew.equals(hanOld)) {
                hanNew.getPersonaList().add(persona);
                hanNew = em.merge(hanNew);
            }
            if (nacionalidadOld != null && !nacionalidadOld.equals(nacionalidadNew)) {
                nacionalidadOld.getPersonaList().remove(persona);
                nacionalidadOld = em.merge(nacionalidadOld);
            }
            if (nacionalidadNew != null && !nacionalidadNew.equals(nacionalidadOld)) {
                nacionalidadNew.getPersonaList().add(persona);
                nacionalidadNew = em.merge(nacionalidadNew);
            }
            if (ocupacionOld != null && !ocupacionOld.equals(ocupacionNew)) {
                ocupacionOld.getPersonaList().remove(persona);
                ocupacionOld = em.merge(ocupacionOld);
            }
            if (ocupacionNew != null && !ocupacionNew.equals(ocupacionOld)) {
                ocupacionNew.getPersonaList().add(persona);
                ocupacionNew = em.merge(ocupacionNew);
            }
            if (miembroConOld != null && !miembroConOld.equals(miembroConNew)) {
                miembroConOld.getPersonaList().remove(persona);
                miembroConOld = em.merge(miembroConOld);
            }
            if (miembroConNew != null && !miembroConNew.equals(miembroConOld)) {
                miembroConNew.getPersonaList().add(persona);
                miembroConNew = em.merge(miembroConNew);
            }
            if (tipoDocumentoOld != null && !tipoDocumentoOld.equals(tipoDocumentoNew)) {
                tipoDocumentoOld.getPersonaList().remove(persona);
                tipoDocumentoOld = em.merge(tipoDocumentoOld);
            }
            if (tipoDocumentoNew != null && !tipoDocumentoNew.equals(tipoDocumentoOld)) {
                tipoDocumentoNew.getPersonaList().add(persona);
                tipoDocumentoNew = em.merge(tipoDocumentoNew);
            }
            for (Direccion direccionListNewDireccion : direccionListNew) {
                if (!direccionListOld.contains(direccionListNewDireccion)) {
                    Persona oldPersonaOfDireccionListNewDireccion = direccionListNewDireccion.getPersona();
                    direccionListNewDireccion.setPersona(persona);
                    direccionListNewDireccion = em.merge(direccionListNewDireccion);
                    if (oldPersonaOfDireccionListNewDireccion != null && !oldPersonaOfDireccionListNewDireccion.equals(persona)) {
                        oldPersonaOfDireccionListNewDireccion.getDireccionList().remove(direccionListNewDireccion);
                        oldPersonaOfDireccionListNewDireccion = em.merge(oldPersonaOfDireccionListNewDireccion);
                    }
                }
            }
            for (ReunionAsistencia reunionAsistenciaListNewReunionAsistencia : reunionAsistenciaListNew) {
                if (!reunionAsistenciaListOld.contains(reunionAsistenciaListNewReunionAsistencia)) {
                    Persona oldPersonaOfReunionAsistenciaListNewReunionAsistencia = reunionAsistenciaListNewReunionAsistencia.getPersona();
                    reunionAsistenciaListNewReunionAsistencia.setPersona(persona);
                    reunionAsistenciaListNewReunionAsistencia = em.merge(reunionAsistenciaListNewReunionAsistencia);
                    if (oldPersonaOfReunionAsistenciaListNewReunionAsistencia != null && !oldPersonaOfReunionAsistenciaListNewReunionAsistencia.equals(persona)) {
                        oldPersonaOfReunionAsistenciaListNewReunionAsistencia.getReunionAsistenciaList().remove(reunionAsistenciaListNewReunionAsistencia);
                        oldPersonaOfReunionAsistenciaListNewReunionAsistencia = em.merge(oldPersonaOfReunionAsistenciaListNewReunionAsistencia);
                    }
                }
            }
            for (Recomendado recomendadoListNewRecomendado : recomendadoListNew) {
                if (!recomendadoListOld.contains(recomendadoListNewRecomendado)) {
                    Persona oldPersonaOfRecomendadoListNewRecomendado = recomendadoListNewRecomendado.getPersona();
                    recomendadoListNewRecomendado.setPersona(persona);
                    recomendadoListNewRecomendado = em.merge(recomendadoListNewRecomendado);
                    if (oldPersonaOfRecomendadoListNewRecomendado != null && !oldPersonaOfRecomendadoListNewRecomendado.equals(persona)) {
                        oldPersonaOfRecomendadoListNewRecomendado.getRecomendadoList().remove(recomendadoListNewRecomendado);
                        oldPersonaOfRecomendadoListNewRecomendado = em.merge(oldPersonaOfRecomendadoListNewRecomendado);
                    }
                }
            }
            for (Recomendado recomendadoList1OldRecomendado : recomendadoList1Old) {
                if (!recomendadoList1New.contains(recomendadoList1OldRecomendado)) {
                    recomendadoList1OldRecomendado.setRecomendador1(null);
                    recomendadoList1OldRecomendado = em.merge(recomendadoList1OldRecomendado);
                }
            }
            for (Recomendado recomendadoList1NewRecomendado : recomendadoList1New) {
                if (!recomendadoList1Old.contains(recomendadoList1NewRecomendado)) {
                    Persona oldRecomendador1OfRecomendadoList1NewRecomendado = recomendadoList1NewRecomendado.getRecomendador1();
                    recomendadoList1NewRecomendado.setRecomendador1(persona);
                    recomendadoList1NewRecomendado = em.merge(recomendadoList1NewRecomendado);
                    if (oldRecomendador1OfRecomendadoList1NewRecomendado != null && !oldRecomendador1OfRecomendadoList1NewRecomendado.equals(persona)) {
                        oldRecomendador1OfRecomendadoList1NewRecomendado.getRecomendadoList1().remove(recomendadoList1NewRecomendado);
                        oldRecomendador1OfRecomendadoList1NewRecomendado = em.merge(oldRecomendador1OfRecomendadoList1NewRecomendado);
                    }
                }
            }
            for (Recomendado recomendadoList2OldRecomendado : recomendadoList2Old) {
                if (!recomendadoList2New.contains(recomendadoList2OldRecomendado)) {
                    recomendadoList2OldRecomendado.setRecomendador2(null);
                    recomendadoList2OldRecomendado = em.merge(recomendadoList2OldRecomendado);
                }
            }
            for (Recomendado recomendadoList2NewRecomendado : recomendadoList2New) {
                if (!recomendadoList2Old.contains(recomendadoList2NewRecomendado)) {
                    Persona oldRecomendador2OfRecomendadoList2NewRecomendado = recomendadoList2NewRecomendado.getRecomendador2();
                    recomendadoList2NewRecomendado.setRecomendador2(persona);
                    recomendadoList2NewRecomendado = em.merge(recomendadoList2NewRecomendado);
                    if (oldRecomendador2OfRecomendadoList2NewRecomendado != null && !oldRecomendador2OfRecomendadoList2NewRecomendado.equals(persona)) {
                        oldRecomendador2OfRecomendadoList2NewRecomendado.getRecomendadoList2().remove(recomendadoList2NewRecomendado);
                        oldRecomendador2OfRecomendadoList2NewRecomendado = em.merge(oldRecomendador2OfRecomendadoList2NewRecomendado);
                    }
                }
            }
            for (Reunion reunionListOldReunion : reunionListOld) {
                if (!reunionListNew.contains(reunionListOldReunion)) {
                    reunionListOldReunion.setPersona(null);
                    reunionListOldReunion = em.merge(reunionListOldReunion);
                }
            }
            for (Reunion reunionListNewReunion : reunionListNew) {
                if (!reunionListOld.contains(reunionListNewReunion)) {
                    Persona oldPersonaOfReunionListNewReunion = reunionListNewReunion.getPersona();
                    reunionListNewReunion.setPersona(persona);
                    reunionListNewReunion = em.merge(reunionListNewReunion);
                    if (oldPersonaOfReunionListNewReunion != null && !oldPersonaOfReunionListNewReunion.equals(persona)) {
                        oldPersonaOfReunionListNewReunion.getReunionList().remove(reunionListNewReunion);
                        oldPersonaOfReunionListNewReunion = em.merge(oldPersonaOfReunionListNewReunion);
                    }
                }
            }
            for (Usuario usuarioListNewUsuario : usuarioListNew) {
                if (!usuarioListOld.contains(usuarioListNewUsuario)) {
                    Persona oldPersonaOfUsuarioListNewUsuario = usuarioListNewUsuario.getPersona();
                    usuarioListNewUsuario.setPersona(persona);
                    usuarioListNewUsuario = em.merge(usuarioListNewUsuario);
                    if (oldPersonaOfUsuarioListNewUsuario != null && !oldPersonaOfUsuarioListNewUsuario.equals(persona)) {
                        oldPersonaOfUsuarioListNewUsuario.getUsuarioList().remove(usuarioListNewUsuario);
                        oldPersonaOfUsuarioListNewUsuario = em.merge(oldPersonaOfUsuarioListNewUsuario);
                    }
                }
            }
            for (Telefono telefonoListNewTelefono : telefonoListNew) {
                if (!telefonoListOld.contains(telefonoListNewTelefono)) {
                    Persona oldPersonaOfTelefonoListNewTelefono = telefonoListNewTelefono.getPersona();
                    telefonoListNewTelefono.setPersona(persona);
                    telefonoListNewTelefono = em.merge(telefonoListNewTelefono);
                    if (oldPersonaOfTelefonoListNewTelefono != null && !oldPersonaOfTelefonoListNewTelefono.equals(persona)) {
                        oldPersonaOfTelefonoListNewTelefono.getTelefonoList().remove(telefonoListNewTelefono);
                        oldPersonaOfTelefonoListNewTelefono = em.merge(oldPersonaOfTelefonoListNewTelefono);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = persona.getPersona();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Direccion> direccionListOrphanCheck = persona.getDireccionList();
            for (Direccion direccionListOrphanCheckDireccion : direccionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Direccion " + direccionListOrphanCheckDireccion + " in its direccionList field has a non-nullable persona field.");
            }
            List<ReunionAsistencia> reunionAsistenciaListOrphanCheck = persona.getReunionAsistenciaList();
            for (ReunionAsistencia reunionAsistenciaListOrphanCheckReunionAsistencia : reunionAsistenciaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the ReunionAsistencia " + reunionAsistenciaListOrphanCheckReunionAsistencia + " in its reunionAsistenciaList field has a non-nullable persona field.");
            }
            List<Recomendado> recomendadoListOrphanCheck = persona.getRecomendadoList();
            for (Recomendado recomendadoListOrphanCheckRecomendado : recomendadoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Recomendado " + recomendadoListOrphanCheckRecomendado + " in its recomendadoList field has a non-nullable persona field.");
            }
            List<Usuario> usuarioListOrphanCheck = persona.getUsuarioList();
            for (Usuario usuarioListOrphanCheckUsuario : usuarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Usuario " + usuarioListOrphanCheckUsuario + " in its usuarioList field has a non-nullable persona field.");
            }
            List<Telefono> telefonoListOrphanCheck = persona.getTelefonoList();
            for (Telefono telefonoListOrphanCheckTelefono : telefonoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Telefono " + telefonoListOrphanCheckTelefono + " in its telefonoList field has a non-nullable persona field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Division division = persona.getDivision();
            if (division != null) {
                division.getPersonaList().remove(persona);
                division = em.merge(division);
            }
            Empresa empresa = persona.getEmpresa();
            if (empresa != null) {
                empresa.getPersonaList().remove(persona);
                empresa = em.merge(empresa);
            }
            EstadoCivil estadoCivil = persona.getEstadoCivil();
            if (estadoCivil != null) {
                estadoCivil.getPersonaList().remove(persona);
                estadoCivil = em.merge(estadoCivil);
            }
            Genero genero = persona.getGenero();
            if (genero != null) {
                genero.getPersonaList().remove(persona);
                genero = em.merge(genero);
            }
            Han han = persona.getHan();
            if (han != null) {
                han.getPersonaList().remove(persona);
                han = em.merge(han);
            }
            Nacionalidad nacionalidad = persona.getNacionalidad();
            if (nacionalidad != null) {
                nacionalidad.getPersonaList().remove(persona);
                nacionalidad = em.merge(nacionalidad);
            }
            Ocupacion ocupacion = persona.getOcupacion();
            if (ocupacion != null) {
                ocupacion.getPersonaList().remove(persona);
                ocupacion = em.merge(ocupacion);
            }
            Tenencia miembroCon = persona.getMiembroCon();
            if (miembroCon != null) {
                miembroCon.getPersonaList().remove(persona);
                miembroCon = em.merge(miembroCon);
            }
            TipoDocumento tipoDocumento = persona.getTipoDocumento();
            if (tipoDocumento != null) {
                tipoDocumento.getPersonaList().remove(persona);
                tipoDocumento = em.merge(tipoDocumento);
            }
            List<Recomendado> recomendadoList1 = persona.getRecomendadoList1();
            for (Recomendado recomendadoList1Recomendado : recomendadoList1) {
                recomendadoList1Recomendado.setRecomendador1(null);
                recomendadoList1Recomendado = em.merge(recomendadoList1Recomendado);
            }
            List<Recomendado> recomendadoList2 = persona.getRecomendadoList2();
            for (Recomendado recomendadoList2Recomendado : recomendadoList2) {
                recomendadoList2Recomendado.setRecomendador2(null);
                recomendadoList2Recomendado = em.merge(recomendadoList2Recomendado);
            }
            List<Reunion> reunionList = persona.getReunionList();
            for (Reunion reunionListReunion : reunionList) {
                reunionListReunion.setPersona(null);
                reunionListReunion = em.merge(reunionListReunion);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
