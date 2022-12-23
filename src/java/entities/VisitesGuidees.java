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
public class VisitesGuidees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_visite_guidee")
    private Long id_visite_guidee;
    @Column(name = "titre")
    private String titre;
    @OneToMany(mappedBy = "visitesGuidees")
    private List<Circuits> circuitss;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "guide_fk")
    private Guide guide;
    @OneToMany
    @JoinColumn(name = "image_fk")
    private List<Images> image;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "duree")
    private String duree;
    @OneToMany
    @JoinColumn(name = "comment_fk")
    private List<Comment> comments;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_visite_guidee != null ? id_visite_guidee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitesGuidees)) {
            return false;
        }
        VisitesGuidees other = (VisitesGuidees) object;
        if ((this.id_visite_guidee == null && other.id_visite_guidee != null) || (this.id_visite_guidee != null && !this.id_visite_guidee.equals(other.id_visite_guidee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VisitesGuidees[ id=" + id_visite_guidee + " ]";
    }
    
}
