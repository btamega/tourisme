/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class NotificationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NotificationID", nullable = false)
    private Long id;
    @Column(name = "Type", nullable = false, length = 45)
    private String type;
    @Column(name = "AuctionID", nullable = false)
    private long auctionId;
    @Column(name = "MessageID", nullable = true)
    private Long messageId;
    @Column(name = "ReceiverID", nullable = false)
    private long receiverId;
    @Column(name = "ActorID", nullable = false)
    private long actorId;
    @Column(name = "isSeen", nullable = true)
    private Byte isSeen;
    @Column(name = "DateAdded")
    private Timestamp DateAdded;
    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="ActorID", nullable = false, insertable = false, updatable = false)
    @JoinColumns({
        @JoinColumn(name="ActorID", referencedColumnName="userId",nullable = false, insertable = false, updatable = false),
        @JoinColumn(name="NotificationID", referencedColumnName="NotificationID")
    })
    private UserEntity actor;

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (int) (auctionId ^ (auctionId >>> 32));
        result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
        result = 31 * result + (int) (receiverId ^ (receiverId >>> 32));
        result = 31 * result + (int) (actorId ^ (actorId >>> 32));
        result = 31 * result + (isSeen != null ? isSeen.hashCode() : 0);
        result = 31 * result + (DateAdded != null ? DateAdded.hashCode() : 0);
        result = 31 * result + (actor != null ? actor.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        if (!Objects.equals(id, that.id)) return false;
        if (auctionId != that.auctionId) return false;
        if (receiverId != that.receiverId) return false;
        if (actorId != that.actorId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;
        if (isSeen != null ? !isSeen.equals(that.isSeen) : that.isSeen != null) return false;
        if (DateAdded != null ? !DateAdded.equals(that.DateAdded) : that.DateAdded != null) return false;
        return actor != null ? actor.equals(that.actor) : that.actor == null;
    }

    @Override
    public String toString() {
        return "NotificationEntity{" +
                "notificationId=" + id +
                ", type='" + type + '\'' +
                ", auctionId=" + auctionId +
                ", messageId=" + messageId +
                ", receiverId=" + receiverId +
                ", actorId=" + actorId +
                ", isSeen=" + isSeen +
                ", DateAdded=" + DateAdded +
                ", actor=" + actor +
                '}';
    }
    
}
