/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

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
    @Column(name = "id_user")
    private Long id_user;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "email",unique = true,nullable = false)
    @Email
    private String email;
    @Column(name = "password",nullable = false)
    @Size(min = 8, max = 20)
    private String password;
    @Column(name = "firstname",nullable = false)
    private String firstName;
    @Column(name = "lastname",nullable = false)
    private String lastName;
    @Column(name = "phoneNumber",nullable = false)
    @Pattern(regexp="(^$|[0-9]{10})")
    @Size(min = 10,max = 10)
    private String phoneNumber;
    @Column(name = "homeAddress",nullable = false)
    private String homeAddress;
    @Column(name = "city",nullable = false)
    private String city;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "isAdmin", columnDefinition = "default false")
    private Boolean isAdmin;
    @OneToMany(mappedBy = "user")
    private List<Address> address;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_user != null ? id_user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id_user == null && other.id_user != null) || (this.id_user != null && !this.id_user.equals(other.id_user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserEntity[ id=" + id_user + " ]";
    }
    
}
