/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.sgipy.miesys.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aito8
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPersona", query = "SELECT p FROM Persona p WHERE p.persona = :persona")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Persona.findByNumeroDocumento", query = "SELECT p FROM Persona p WHERE p.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Persona.findByCantidadHijos", query = "SELECT p FROM Persona p WHERE p.cantidadHijos = :cantidadHijos")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByFechaInicio", query = "SELECT p FROM Persona p WHERE p.fechaInicio = :fechaInicio")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona")
    private Integer persona;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "cantidad_hijos")
    private Integer cantidadHijos;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @JoinColumn(name = "division", referencedColumnName = "division")
    @ManyToOne
    private Division division;
    @JoinColumn(name = "empresa", referencedColumnName = "empresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "estado_civil", referencedColumnName = "estado_civil")
    @ManyToOne
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "genero", referencedColumnName = "genero")
    @ManyToOne(optional = false)
    private Genero genero;
    @JoinColumn(name = "han", referencedColumnName = "han")
    @ManyToOne
    private Han han;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "nacionalidad")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidad;
    @JoinColumn(name = "ocupacion", referencedColumnName = "ocupacion")
    @ManyToOne
    private Ocupacion ocupacion;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento")
    @ManyToOne
    private TipoDocumento tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Direccion> direccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Recomendado> recomendadoList;
    @OneToMany(mappedBy = "recomendador1")
    private List<Recomendado> recomendadoList1;
    @OneToMany(mappedBy = "recomendador2")
    private List<Recomendado> recomendadoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Telefono> telefonoList;

    public Persona() {
    }

    public Persona(Integer persona) {
        this.persona = persona;
    }

    public Persona(Integer persona, String nombre, String apellido) {
        this.persona = persona;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(Integer cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Han getHan() {
        return han;
    }

    public void setHan(Han han) {
        this.han = han;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    @XmlTransient
    public List<Recomendado> getRecomendadoList() {
        return recomendadoList;
    }

    public void setRecomendadoList(List<Recomendado> recomendadoList) {
        this.recomendadoList = recomendadoList;
    }

    @XmlTransient
    public List<Recomendado> getRecomendadoList1() {
        return recomendadoList1;
    }

    public void setRecomendadoList1(List<Recomendado> recomendadoList1) {
        this.recomendadoList1 = recomendadoList1;
    }

    @XmlTransient
    public List<Recomendado> getRecomendadoList2() {
        return recomendadoList2;
    }

    public void setRecomendadoList2(List<Recomendado> recomendadoList2) {
        this.recomendadoList2 = recomendadoList2;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persona != null ? persona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.persona == null && other.persona != null) || (this.persona != null && !this.persona.equals(other.persona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Persona[ persona=" + persona + " ]";
    }
    
}
