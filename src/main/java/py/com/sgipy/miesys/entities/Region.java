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
@Table(name = "region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")
    , @NamedQuery(name = "Region.findByRegion", query = "SELECT r FROM Region r WHERE r.region = :region")
    , @NamedQuery(name = "Region.findByDescripcion", query = "SELECT r FROM Region r WHERE r.descripcion = :descripcion")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "region")
    private Integer region;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    private List<Cabildo> cabildoList;

    public Region() {
    }

    public Region(Integer region) {
        this.region = region;
    }

    public Region(Integer region, String descripcion) {
        this.region = region;
        this.descripcion = descripcion;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Cabildo> getCabildoList() {
        return cabildoList;
    }

    public void setCabildoList(List<Cabildo> cabildoList) {
        this.cabildoList = cabildoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (region != null ? region.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.region == null && other.region != null) || (this.region != null && !this.region.equals(other.region))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Region[ region=" + region + " ]";
    }
    
}
