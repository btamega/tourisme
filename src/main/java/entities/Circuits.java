/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Data
@Entity
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
    @ManyToOne
    @JoinColumn(name = "visite_fk")
    private VisitesGuidees visitesGuidees;
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
