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
    , @NamedQuery(name = "ReunionAsistencia.findByReunionAsistencia", query = "SELECT r FROM ReunionAsistencia r WHERE r.reunionAsistencia = :reunionAsistencia")
    , @NamedQuery(name = "ReunionAsistencia.findByReunion", query = "SELECT r FROM ReunionAsistencia r WHERE r.reunion = :reunion")
    , @NamedQuery(name = "ReunionAsistencia.findByPersona", query = "SELECT r FROM ReunionAsistencia r WHERE r.persona = :persona")})
public class ReunionAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reunion_asistencia")
    private Integer reunionAsistencia;
    @Basic(optional = false)
    @Column(name = "reunion")
    private int reunion;
    @Basic(optional = false)
    @Column(name = "persona")
    private int persona;

    public ReunionAsistencia() {
    }

    public ReunionAsistencia(Integer reunionAsistencia) {
        this.reunionAsistencia = reunionAsistencia;
    }

    public ReunionAsistencia(Integer reunionAsistencia, int reunion, int persona) {
        this.reunionAsistencia = reunionAsistencia;
        this.reunion = reunion;
        this.persona = persona;
    }

    public Integer getReunionAsistencia() {
        return reunionAsistencia;
    }

    public void setReunionAsistencia(Integer reunionAsistencia) {
        this.reunionAsistencia = reunionAsistencia;
    }

    public int getReunion() {
        return reunion;
    }

    public void setReunion(int reunion) {
        this.reunion = reunion;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
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
