/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class Circuits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "pointDep")
    private String pointDep;
    @Column(name = "pointArr")
    private String pointArr;
    @Column(name = "duree")
    private String duree;
    @Column(name = "prix")
    private int prix;
    @ManyToOne
    @JoinColumn(name = "guide_fk")
    private Guide guide;
    @JoinColumn(name = "visite_fk")
    @ManyToOne
    private VisitesGuidees visitesGuidees;
    @OneToMany
    @JoinColumn(name = "image_fk")
    private List<Images> images;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Circuits)) {
            return false;
        }
        Circuits other = (Circuits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Circuits[ id=" + id + " ]";
    }
    
}
