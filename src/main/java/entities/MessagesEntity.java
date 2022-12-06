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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class MessagesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MessageID")
    private Long id;
    @Column(name="SenderID")
    private long senderId;
    @Column(name="ReceiverID")
    private long receiverId;
    @Column(name="AuctionID")
    private long auctionId;
    @Column(name = "Message")
    private String message;
    @Column(name = "SendDate")
    private Timestamp sendDate;
    @Column(name = "IsRead")
    private byte isRead;

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (senderId ^ (senderId >>> 32));
        result = 31 * result + (int) (receiverId ^ (receiverId >>> 32));
        result = 31 * result + (int) (auctionId ^ (auctionId >>> 32));
        result = 31 * result + message.hashCode();
        result = 31 * result + sendDate.hashCode();
        result = 31 * result + (int) isRead;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessagesEntity that = (MessagesEntity) o;
        if (!Objects.equals(id, that.id)) return false;
        if (senderId != that.senderId) return false;
        if (receiverId != that.receiverId) return false;
        if (auctionId != that.auctionId) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;
        if (isRead != that.isRead) return false;

        return true;
    }

    @Override
    public String toString() {
        return "MessagesEntity{" +
                "messageId=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", auctionId=" + auctionId +
                ", message='" + message + '\'' +
                ", sendDate=" + sendDate +
                ", isRead=" + isRead +
                '}';
    }
    
}
