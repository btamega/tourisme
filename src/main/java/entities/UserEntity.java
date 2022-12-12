/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "HashCode")
    private byte[] hashCode;
    @Column(name = "Salt")
    private byte[] salt;
    @Column(name = "Firstname")
    private String firstname;
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "Email")
    private String email;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "Vat")
    private String vat;
    @Column(name = "HomeAddress")
    private String homeAddress;
    @Column(name = "Latitude")
    private String latitude;
    @Column(name = "Longitude")
    private String longitude;
    @Column(name = "City")
    private String city;
    @Column(name = "Country")
    private String country;
    @Column(name = "SignUpDate")
    @Temporal(TemporalType.DATE)
    private Date signUpDate;
    @Column(name = "IsAdmin")
    private byte isAdmin;
    @Column(name = "isApproved")
    private byte isApproved;
    @OneToMany
    private Set<AuctionEntity> auctions;
    @Transient
    private Integer ratingAsSeller = 0;
    @Transient
    private Integer ratingAsBidder = 0;
    @OneToMany(mappedBy = "receiver")
    private List<RatingEntity> ratingEntitys;
    @OneToMany(mappedBy = "actor")
    @OrderBy("DateAdded DESC")
    private List<NotificationEntity> notificationEntitys;
    @OneToOne(mappedBy = "bidder")
    private BidEntity bidEntity;
    @OneToMany(mappedBy = "AUser")
    private List<Address> address;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserEntity[ id=" + id + " ]";
    }
    
}
