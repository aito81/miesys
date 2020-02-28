/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.sgipy.miesys.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tenencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tenencia.findAll", query = "SELECT t FROM Tenencia t")
    , @NamedQuery(name = "Tenencia.findByTenencia", query = "SELECT t FROM Tenencia t WHERE t.tenencia = :tenencia")
    , @NamedQuery(name = "Tenencia.findByDescripcion", query = "SELECT t FROM Tenencia t WHERE t.descripcion = :descripcion")})
public class Tenencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tenencia")
    private Integer tenencia;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "miembroCon")
    private List<Persona> personaList;

    public Tenencia() {
    }

    public Tenencia(Integer tenencia) {
        this.tenencia = tenencia;
    }

    public Tenencia(Integer tenencia, String descripcion) {
        this.tenencia = tenencia;
        this.descripcion = descripcion;
    }

    public Integer getTenencia() {
        return tenencia;
    }

    public void setTenencia(Integer tenencia) {
        this.tenencia = tenencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tenencia != null ? tenencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tenencia)) {
            return false;
        }
        Tenencia other = (Tenencia) object;
        if ((this.tenencia == null && other.tenencia != null) || (this.tenencia != null && !this.tenencia.equals(other.tenencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Tenencia[ tenencia=" + tenencia + " ]";
    }
    
}
