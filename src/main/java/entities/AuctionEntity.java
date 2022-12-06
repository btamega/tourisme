package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Set;
import lombok.Data;

/**
 * Class that describes an auction entity. (An item for sale).
 */
@Entity
@Data
@Embeddable
public class AuctionEntity implements Serializable {
    @Id
    @Column(name = "AuctionId")
    private long auctionId;
    @Column(name = "SellerID")
    private Long sellerId;
    @Column(name = "BuyerID")
    private Long buyerId;
    @Column(name = "Name")
    private String name;
    @ManyToMany(targetEntity = CategoryEntity.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//        name="auction_has_category",
//        joinColumns={
//            @JoinColumn(name="auction_AuctionID", referencedColumnName="AuctionId"),
//            @JoinColumn(name="category_CategoryID", referencedColumnName="CategoryID")
//        },
//        inverseJoinColumns=
//            @JoinColumn(name="category_CategoryID", referencedColumnName="CategoryID")
//    )
    @JoinColumns({
        @JoinColumn(name="auction_AuctionID", referencedColumnName="AuctionId"),
        @JoinColumn(name="category_CategoryID", referencedColumnName="CategoryID")
    })
    private Set<CategoryEntity> categories;
    @Transient
    private Double currently;
    @Column(name = "LowestBid")
    private double lowestBid;
    @Transient
    private int numOfBids;
    @OneToMany(targetEntity = BidEntity.class, mappedBy = "auction", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("amount DESC")
    private Set<BidEntity> bids;
//    @OneToMany(targetEntity = Images.class, mappedBy = "auction",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<Images> images;
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
    private Timestamp startingDate;
    @Column(name = "EndingDate")
    private Timestamp endingDate;
    @Column(name = "Description", nullable = true)
    private String description;
    @ManyToOne
//    @JoinColumn(name="SellerID", nullable = false, insertable = false, updatable = false)
    @JoinColumns({
        @JoinColumn(name="SellerID", referencedColumnName="userId",nullable = false, insertable = false, updatable = false),
        @JoinColumn(name="AuctionId", referencedColumnName="AuctionId")
    })
    private UserEntity seller;
   


    public void setBidStuff(){
        if ( !bids.isEmpty() ){
            Iterator iter = bids.iterator();
            numOfBids = bids.size();
            BidEntity bid = (BidEntity) iter.next();
            currently = bid.getAmount();
            // this will compute the sum for user when is a bidder
            bid.getBidder().setRatingAs("bidder");
        } else{
            numOfBids = 0;
            currently = lowestBid;
        }
    }

    @Override
    public String toString() {
        return "AuctionEntity{" +
                "auctionId=" + auctionId +
                ", sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", name='" + name + '\'' +
                ", categories=" + categories +
                ", lowestBid=" + lowestBid +
                ", bids=" + bids +
//                ", images=" + images +
                ", location='" + location + '\'' +
                ", country='" + country + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", isActive=" + isActive +
                ", buyPrice=" + buyPrice +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", description='" + description + '\'' +
                '}';
    }

    @Transient
    public Long getIdOfHighestBidder(){
        Long BidderID = null;
        Double highestBid = 0.0;
        for (BidEntity bid : bids ) {
            if (bid.getAmount() > highestBid){
                BidderID = bid.getBidderId();
                highestBid = bid.getAmount();
            }
        }
        return BidderID;
    }
}