/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author scarFace
 */
@Entity
@Table(catalog = "administration", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Droit.findAll", query = "SELECT d FROM Droit d"),
    @NamedQuery(name = "Droit.findById", query = "SELECT d FROM Droit d WHERE d.id = :id"),
    @NamedQuery(name = "Droit.findByLibelle", query = "SELECT d FROM Droit d WHERE d.libelle = :libelle"),
    @NamedQuery(name = "Droit.findByMenu", query = "SELECT d FROM Droit d WHERE d.menu = :menu"),
    @NamedQuery(name = "Droit.findByActif", query = "SELECT d FROM Droit d WHERE d.actif = :actif")})
public class Droit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 254)
    private String libelle;
    @Column(length = 254)
    private String menu;
    private Boolean actif;
    @JoinColumn(name = "Pro_id", referencedColumnName = "id")
    @ManyToOne
    private Profil proid;

    public Droit() {
    }

    public Droit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Profil getProid() {
        return proid;
    }

    public void setProid(Profil proid) {
        this.proid = proid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Droit)) {
            return false;
        }
        Droit other = (Droit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Droit[ id=" + id + " ]";
    }
    
}
