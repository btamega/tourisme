/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class Attractions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_attraction")
    private Long id_attraction;
    @Column(name = "ville")
    private String ville;
    @OneToOne
    @JoinColumn(name = "address_fk")
    private Address adresse;
    @Column(name = "couverture")
    private String couverture;
    @Column(name = "heureOuverture")
    @Temporal(TemporalType.DATE)
    private Date heureOuverture;
    @Column(name = "heureFermeture")
    @Temporal(TemporalType.DATE)
    private Date heureFermeture;
    @Column(name = "type")
    private String type;
    @OneToMany
    @JoinColumn(name = "image_fk")
    private List<Images> images;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_attraction != null ? id_attraction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attractions)) {
            return false;
        }
        Attractions other = (Attractions) object;
        if ((this.id_attraction == null && other.id_attraction != null) || (this.id_attraction != null && !this.id_attraction.equals(other.id_attraction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Attractions[ id=" + id_attraction + " ]";
    }
    
}
