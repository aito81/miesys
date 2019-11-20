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
@Table(name = "recomendado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recomendado.findAll", query = "SELECT r FROM Recomendado r")
    , @NamedQuery(name = "Recomendado.findByRecomendado", query = "SELECT r FROM Recomendado r WHERE r.recomendado = :recomendado")})
public class Recomendado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recomendado")
    private Integer recomendado;
    @JoinColumn(name = "persona", referencedColumnName = "persona")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "recomendador1", referencedColumnName = "persona")
    @ManyToOne
    private Persona recomendador1;
    @JoinColumn(name = "recomendador2", referencedColumnName = "persona")
    @ManyToOne
    private Persona recomendador2;

    public Recomendado() {
    }

    public Recomendado(Integer recomendado) {
        this.recomendado = recomendado;
    }

    public Integer getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(Integer recomendado) {
        this.recomendado = recomendado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getRecomendador1() {
        return recomendador1;
    }

    public void setRecomendador1(Persona recomendador1) {
        this.recomendador1 = recomendador1;
    }

    public Persona getRecomendador2() {
        return recomendador2;
    }

    public void setRecomendador2(Persona recomendador2) {
        this.recomendador2 = recomendador2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recomendado != null ? recomendado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recomendado)) {
            return false;
        }
        Recomendado other = (Recomendado) object;
        if ((this.recomendado == null && other.recomendado != null) || (this.recomendado != null && !this.recomendado.equals(other.recomendado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.sgipy.miesys.entities.Recomendado[ recomendado=" + recomendado + " ]";
    }
    
}
