/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
@Table(name="AuctionEntity",schema = "AuctionEntity", catalog="public")
public class AuctionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AuctionId")
    private Long id;
    @Column(name = "SellerID")
    private Long sellerId;
    @Column(name = "BuyerID")
    private Long buyerId;
    @Column(name = "Name")
    private String name;
    @ManyToMany
    private Set<CategoryEntity> categories;
    @Column(name = "Location")
    private String location;
    @Column(name = "Country")
    private String country;
    @Column(name = "Longitude")
    private double longitude;
    @Column(name = "Latitude")
    private double latitude;
    @Column(name = "isActive")
    private Byte isActive;
    @Column(name = "BuyPrice", nullable = true)
    private Double buyPrice;
    @Column(name = "StartingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDate;
    @Column(name = "EndingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endingDate;
    @Column(name = "Description", nullable = true)
    private String description;
    @ManyToOne
    private UserEntity seller;
    @OneToMany(mappedBy = "auction")
    @OrderBy("amount DESC")
    private Set<BidEntity> bids;
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuctionEntity)) {
            return false;
        }
        AuctionEntity other = (AuctionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AuctionEntity[ id=" + id + " ]";
    }
    
}
