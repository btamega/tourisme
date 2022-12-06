/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    private Long id;
    @Column(name = "FromID")
    private long fromId;
    @Column(name = "ToID")
    private long toId;
    @Column(name = "AuctionId")
    private long auctionId;
    @Column(name = "Rating")
    private int rating;
    @Column(name = "isSeller")
    private Byte isSeller; // the toID attribute is the id of seller
    @ManyToOne
//    @JoinColumn(name="ToID", insertable = false, updatable = false)
    @JoinColumns({
        @JoinColumn(name="ToID", referencedColumnName="ToID"),
        @JoinColumn(name="userId", referencedColumnName="userId")
    })
    private UserEntity receiver;
    

    @Override
    public int hashCode() {
        int result = (int) (fromId ^ (fromId >>> 32));
        result = 31 * result + (int) (toId ^ (toId >>> 32));
        result = 31 * result + (int) (auctionId ^ (auctionId >>> 32));
        result = 31 * result + rating;
        return result;
    }

    @Override
    public boolean equals(Object o) {
         if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingEntity that = (RatingEntity) o;

        if (fromId != that.fromId) return false;
        if (toId != that.toId) return false;
        if (auctionId != that.auctionId) return false;
        return rating == that.rating;
    }

    @Override
    public String toString() {
        return "RatingEntity{" +
                "fromId=" + fromId +
                ", toId=" + toId +
                ", auctionId=" + auctionId +
                ", rating=" + rating +
                ", isSeller=" + isSeller +
                '}';
    }
    
}
