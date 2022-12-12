/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateAdded;
    @ManyToOne
    private UserEntity actor;

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationEntity)) {
            return false;
        }
        NotificationEntity other = (NotificationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotificationEntity[ id=" + id + " ]";
    }
    
}
