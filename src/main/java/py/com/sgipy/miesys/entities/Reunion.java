/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.sgipy.miesys.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r")
    , @NamedQuery(name = "Reunion.findByReunion", query = "SELECT r FROM Reunion r WHERE r.reunion = :reunion")
    , @NamedQuery(name = "Reunion.findByFecha", query = "SELECT r FROM Reunion r WHERE r.fecha = :fecha")})
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
    @JoinColumn(name = "estudio", referencedColumnName = "estudio")
    @ManyToOne
    private Estudio estudio;
    @JoinColumn(name = "han", referencedColumnName = "han")
    @ManyToOne(optional = false)
    private Han han;

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
