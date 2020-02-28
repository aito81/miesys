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
@Table(name = "reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r")
    , @NamedQuery(name = "Reunion.findByReunion", query = "SELECT r FROM Reunion r WHERE r.reunion = :reunion")
    , @NamedQuery(name = "Reunion.findByFecha", query = "SELECT r FROM Reunion r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reunion.findByCantidadParticipantes", query = "SELECT r FROM Reunion r WHERE r.cantidadParticipantes = :cantidadParticipantes")})
public class Reunion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reunion")
    private Integer reunion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "cantidad_participantes")
    private Integer cantidadParticipantes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reunion")
    private List<ReunionAsistencia> reunionAsistenciaList;
    @JoinColumn(name = "estudio", referencedColumnName = "estudio")
    @ManyToOne
    private Estudio estudio;
    @JoinColumn(name = "han", referencedColumnName = "han")
    @ManyToOne(optional = false)
    private Han han;
    @JoinColumn(name = "persona", referencedColumnName = "persona")
    @ManyToOne
    private Persona persona;

    public Reunion() {
    }

    public Reunion(Integer reunion) {
        this.reunion = reunion;
    }

    public Reunion(Integer reunion, Date fecha) {
        this.reunion = reunion;
        this.fecha = fecha;
    }

    public Integer getReunion() {
        return reunion;
    }

    public void setReunion(Integer reunion) {
        this.reunion = reunion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(Integer cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    @XmlTransient
    public List<ReunionAsistencia> getReunionAsistenciaList() {
        return reunionAsistenciaList;
    }

    public void setReunionAsistenciaList(List<ReunionAsistencia> reunionAsistenciaList) {
        this.reunionAsistenciaList = reunionAsistenciaList;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Han getHan() {
        return han;
    }

    public void setHan(Han han) {
        this.han = han;
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
        hash += (reunion != null ? reunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reunion)) {
            return false;
        }
        Reunion other = (Reunion) object;
        if ((this.reunion == null && other.reunion != null) || (this.reunion != null && !this.reunion.equals(other.reunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Reunion[ reunion=" + reunion + " ]";
    }
    
}
