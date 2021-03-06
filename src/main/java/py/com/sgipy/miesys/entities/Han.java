/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.sgipy.miesys.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aito8
 */
@Entity
@Table(name = "han")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Han.findAll", query = "SELECT h FROM Han h")
    , @NamedQuery(name = "Han.findByHan", query = "SELECT h FROM Han h WHERE h.han = :han")
    , @NamedQuery(name = "Han.findByDescripcion", query = "SELECT h FROM Han h WHERE h.descripcion = :descripcion")
    , @NamedQuery(name = "Han.findByDireccion", query = "SELECT h FROM Han h WHERE h.direccion = :direccion")
    , @NamedQuery(name = "Han.findByCantidadMiembros", query = "SELECT h FROM Han h WHERE h.cantidadMiembros = :cantidadMiembros")})
public class Han implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "han")
    private Integer han;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "cantidad_miembros")
    private Integer cantidadMiembros;
    @OneToMany(mappedBy = "han")
    private List<Persona> personaList;
    @JoinColumn(name = "barrio", referencedColumnName = "barrio")
    @ManyToOne
    private Barrio barrio;
    @JoinColumn(name = "distrito", referencedColumnName = "distrito")
    @ManyToOne(optional = false)
    private Distrito distrito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "han")
    private List<Reunion> reunionList;

    public Han() {
    }

    public Han(Integer han) {
        this.han = han;
    }

    public Han(Integer han, String descripcion) {
        this.han = han;
        this.descripcion = descripcion;
    }

    public Integer getHan() {
        return han;
    }

    public void setHan(Integer han) {
        this.han = han;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCantidadMiembros() {
        return cantidadMiembros;
    }

    public void setCantidadMiembros(Integer cantidadMiembros) {
        this.cantidadMiembros = cantidadMiembros;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    @XmlTransient
    public List<Reunion> getReunionList() {
        return reunionList;
    }

    public void setReunionList(List<Reunion> reunionList) {
        this.reunionList = reunionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (han != null ? han.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Han)) {
            return false;
        }
        Han other = (Han) object;
        if ((this.han == null && other.han != null) || (this.han != null && !this.han.equals(other.han))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Han[ han=" + han + " ]";
    }
    
}
