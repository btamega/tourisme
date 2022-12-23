/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class RatingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rating")
    private Long id_rating;
    @Column(name = "FromID")
    private long fromId;
    @Column(name = "ToID")
    private long toId;
    @Column(name = "AuctionId")
    private long auctionId;
    @Column(name = "Rating")
    private int rating;
    @Column(name = "isSeller")
    private Boolean isSeller;
    @ManyToOne
    private UserEntity receiver;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_rating != null ? id_rating.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingEntity)) {
            return false;
        }
        RatingEntity other = (RatingEntity) object;
        if ((this.id_rating == null && other.id_rating != null) || (this.id_rating != null && !this.id_rating.equals(other.id_rating))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RatingEntity[ id=" + id_rating + " ]";
    }
    
}
