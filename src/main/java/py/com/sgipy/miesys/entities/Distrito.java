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
 * @author Santiago
 */
@Entity
@Table(name = "distrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d")
    , @NamedQuery(name = "Distrito.findByDistrito", query = "SELECT d FROM Distrito d WHERE d.distrito = :distrito")
    , @NamedQuery(name = "Distrito.findByDescripcion", query = "SELECT d FROM Distrito d WHERE d.descripcion = :descripcion")})
public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "distrito")
    private Integer distrito;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "cabildo", referencedColumnName = "cabildo")
    @ManyToOne(optional = false)
    private Cabildo cabildo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distrito")
    private List<Han> hanList;

    public Distrito() {
    }

    public Distrito(Integer distrito) {
        this.distrito = distrito;
    }

    public Distrito(Integer distrito, String descripcion) {
        this.distrito = distrito;
        this.descripcion = descripcion;
    }

    public Integer getDistrito() {
        return distrito;
    }

    public void setDistrito(Integer distrito) {
        this.distrito = distrito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cabildo getCabildo() {
        return cabildo;
    }

    public void setCabildo(Cabildo cabildo) {
        this.cabildo = cabildo;
    }

    @XmlTransient
    public List<Han> getHanList() {
        return hanList;
    }

    public void setHanList(List<Han> hanList) {
        this.hanList = hanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distrito != null ? distrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.distrito == null && other.distrito != null) || (this.distrito != null && !this.distrito.equals(other.distrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Distrito[ distrito=" + distrito + " ]";
    }
    
}
