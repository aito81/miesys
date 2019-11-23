/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.sgipy.miesys.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aito8
 */
@Entity
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByDireccion", query = "SELECT d FROM Direccion d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "Direccion.findByDescripcion", query = "SELECT d FROM Direccion d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Direccion.findByLaboral", query = "SELECT d FROM Direccion d WHERE d.laboral = :laboral")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "direccion")
    private Integer direccion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "laboral")
    private boolean laboral;
    @JoinColumn(name = "ciudad", referencedColumnName = "ciudad")
    @ManyToOne
    private Ciudad ciudad;
    @JoinColumn(name = "persona", referencedColumnName = "persona")
    @ManyToOne(optional = false)
    private Persona persona;

    public Direccion() {
    }

    public Direccion(Integer direccion) {
        this.direccion = direccion;
    }

    public Direccion(Integer direccion, String descripcion, boolean laboral) {
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.laboral = laboral;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getLaboral() {
        return laboral;
    }

    public void setLaboral(boolean laboral) {
        this.laboral = laboral;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccion != null ? direccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.direccion == null && other.direccion != null) || (this.direccion != null && !this.direccion.equals(other.direccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Direccion[ direccion=" + direccion + " ]";
    }
    
}
