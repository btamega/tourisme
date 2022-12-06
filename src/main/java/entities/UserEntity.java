package entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Long userId;
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
    @OneToMany(targetEntity = NotificationEntity.class, mappedBy = "actor", fetch = FetchType.EAGER)
    @OrderBy("DateAdded DESC")
    private Set<NotificationEntity> notifications;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
    private Set<AuctionEntity> auctions;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receiver")
    private Set<RatingEntity> rating;
    @Transient
    private Integer ratingAsSeller = 0;
    @Transient
    private Integer ratingAsBidder = 0;
    public void setRatingAs(String usr_type){
        if (!rating.isEmpty()) {
            if (usr_type.equals("seller")){
                this.ratingAsSeller = 0; // do this because
                for (RatingEntity r : rating)
                    this.ratingAsSeller += r.getIsSeller() == 1 ? r.getRating() : 0;
            }
            else if (usr_type.equals("bidder")){
                this.ratingAsBidder = 0; // do this because
                for (RatingEntity r : rating)
                    this.ratingAsBidder += r.getIsSeller() == 0 ? r.getRating() : 0;
            }
        }
    }
    @Override
    public int hashCode() {
         int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (hashCode != null ? Arrays.hashCode(hashCode) : 0);
        result = 31 * result + (salt != null ? Arrays.hashCode(salt) : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (signUpDate != null ? signUpDate.hashCode() : 0);
        result = 31 * result + (int) isAdmin;
        result = 31 * result + (int) isApproved;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (!Objects.equals(userId, that.userId)) return false;
        if (isAdmin != that.isAdmin) return false;
        if (isApproved != that.isApproved) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (hashCode != null ? !Arrays.equals(hashCode, that.hashCode) : that.hashCode != null) return false;
        if (salt != null ? !Arrays.equals(salt, that.salt) : that.salt != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (vat != null ? !vat.equals(that.vat) : that.vat != null) return false;
        if (homeAddress != null ? !homeAddress.equals(that.homeAddress) : that.homeAddress != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (signUpDate != null ? !signUpDate.equals(that.signUpDate) : that.signUpDate != null) return false;

        return true;
    }

    @Override
    public String toString() {
         return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", hash=" + Arrays.toString(hashCode) +
                ", salt=" + Arrays.toString(salt) +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vat='" + vat + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", signUpDate=" + signUpDate +
                ", isAdmin=" + isAdmin +
                ", isApproved=" + isApproved +
//                ", rating=" + rating +
                ", notifications=" + notifications +
                '}';
    }
    
}
