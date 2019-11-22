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
 * @author Santiago
 */
@Entity
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
    , @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Telefono.findByDescripcion", query = "SELECT t FROM Telefono t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Telefono.findByLaboral", query = "SELECT t FROM Telefono t WHERE t.laboral = :laboral")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "telefono")
    private Integer telefono;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "laboral")
    private boolean laboral;
    @JoinColumn(name = "persona", referencedColumnName = "persona")
    @ManyToOne(optional = false)
    private Persona persona;

    public Telefono() {
    }

    public Telefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Telefono(Integer telefono, String descripcion, boolean laboral) {
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.laboral = laboral;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefono != null ? telefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefono == null && other.telefono != null) || (this.telefono != null && !this.telefono.equals(other.telefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Telefono[ telefono=" + telefono + " ]";
    }
    
}
