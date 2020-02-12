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
@Table(name = "cabildo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabildo.findAll", query = "SELECT c FROM Cabildo c")
    , @NamedQuery(name = "Cabildo.findByCabildo", query = "SELECT c FROM Cabildo c WHERE c.cabildo = :cabildo")
    , @NamedQuery(name = "Cabildo.findByDescripcion", query = "SELECT c FROM Cabildo c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Cabildo.findByRegion", query = "SELECT c FROM Cabildo c WHERE c.region = :region")})
public class Cabildo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabildo")
    private Integer cabildo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "region")
    private int region;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabildo")
    private List<Distrito> distritoList;

    public Cabildo() {
    }

    public Cabildo(Integer cabildo) {
        this.cabildo = cabildo;
    }

    public Cabildo(Integer cabildo, String descripcion, int region) {
        this.cabildo = cabildo;
        this.descripcion = descripcion;
        this.region = region;
    }

    public Integer getCabildo() {
        return cabildo;
    }

    public void setCabildo(Integer cabildo) {
        this.cabildo = cabildo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    @XmlTransient
    public List<Distrito> getDistritoList() {
        return distritoList;
    }

    public void setDistritoList(List<Distrito> distritoList) {
        this.distritoList = distritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabildo != null ? cabildo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabildo)) {
            return false;
        }
        Cabildo other = (Cabildo) object;
        if ((this.cabildo == null && other.cabildo != null) || (this.cabildo != null && !this.cabildo.equals(other.cabildo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Cabildo[ cabildo=" + cabildo + " ]";
    }
    
}
