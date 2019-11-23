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
@Table(name = "reunion_asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReunionAsistencia.findAll", query = "SELECT r FROM ReunionAsistencia r")
    , @NamedQuery(name = "ReunionAsistencia.findByReunionAsistencia", query = "SELECT r FROM ReunionAsistencia r WHERE r.reunionAsistencia = :reunionAsistencia")})
public class ReunionAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reunion_asistencia")
    private Integer reunionAsistencia;
    @JoinColumn(name = "persona", referencedColumnName = "persona")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "reunion", referencedColumnName = "reunion")
    @ManyToOne(optional = false)
    private Reunion reunion;

    public ReunionAsistencia() {
    }

    public ReunionAsistencia(Integer reunionAsistencia) {
        this.reunionAsistencia = reunionAsistencia;
    }

    public Integer getReunionAsistencia() {
        return reunionAsistencia;
    }

    public void setReunionAsistencia(Integer reunionAsistencia) {
        this.reunionAsistencia = reunionAsistencia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reunionAsistencia != null ? reunionAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReunionAsistencia)) {
            return false;
        }
        ReunionAsistencia other = (ReunionAsistencia) object;
        if ((this.reunionAsistencia == null && other.reunionAsistencia != null) || (this.reunionAsistencia != null && !this.reunionAsistencia.equals(other.reunionAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.ReunionAsistencia[ reunionAsistencia=" + reunionAsistencia + " ]";
    }
    
}
