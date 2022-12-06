package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import lombok.Data;

/**
 * Class that describes a bid entity. (A bid placed on an item for sale).
 */
@Entity
@Data
public class BidEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Bid")
    private long bidid;
    @Column(name = "BidderID")
    private long bidderId;
    @OneToOne
//    @JoinColumn(name="BidderID", referencedColumnName = "userId", insertable = false, updatable = false)
    @JoinColumns({
        @JoinColumn(name="BidderID", referencedColumnName="userId",insertable = false, updatable = false),
        @JoinColumn(name="Bid", referencedColumnName="Bid")
    })
    private UserEntity bidder;
    @Column(name = "BidTime")
    private Timestamp bidTime;
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "AuctionID")
    private long auctionId;
    @ManyToOne
//    @JoinColumn(name="AuctionID", nullable = true, insertable = false, updatable = false)
    @JoinColumns({
        @JoinColumn(name="AuctionID", referencedColumnName="AuctionId"),
        @JoinColumn(name="Bid", referencedColumnName="Bid")
    })
    private AuctionEntity auction;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BidEntity bidEntity = (BidEntity) o;

        if (bidid != bidEntity.bidid) return false;
        if (bidderId != bidEntity.bidderId) return false;
        if (auctionId != bidEntity.auctionId) return false;
        if (bidder != null ? !bidder.equals(bidEntity.bidder) : bidEntity.bidder != null) return false;
        if (bidTime != null ? !bidTime.equals(bidEntity.bidTime) : bidEntity.bidTime != null) return false;
        if (amount != null ? !amount.equals(bidEntity.amount) : bidEntity.amount != null) return false;
        return auction != null ? auction.equals(bidEntity.auction) : bidEntity.auction == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (bidid ^ (bidid >>> 32));
        result = 31 * result + (int) (bidderId ^ (bidderId >>> 32));
        result = 31 * result + (bidder != null ? bidder.hashCode() : 0);
        result = 31 * result + (bidTime != null ? bidTime.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (int) (auctionId ^ (auctionId >>> 32));
        result = 31 * result + (auction != null ? auction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BidEntity{" +
                "bidid=" + bidid +
                ", bidderId=" + bidderId +
                ", bidder=" + bidder +
                ", bidTime=" + bidTime +
                ", amount=" + amount +
                ", auctionId=" + auctionId +
                ", auction=" + auction +
                '}';
    }

}