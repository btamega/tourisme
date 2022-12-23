/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Hotels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ville")
    private String ville;
    @Column(name = "equipements")
    private List<String> equipements;
    @OneToOne
    @JoinColumn(name = "reservation_fk")
    private Reservation reservation;
    @Column(name = "chambres")
    private int nombreChambre;
    @Column(name = "etoiles")
    private int nombreEtoiles;
    @Column(name = "phoneNumber",nullable = false)
    @Pattern(regexp="(^$|[0-9]{10})")
    @Size(min = 10,max = 10)
    private String phoneNumber;
    @OneToMany
    @JoinColumn(name = "image_fk")
    private List<Images> images;
    @OneToOne
    @JoinColumn(name = "address_fk")
    private Address adresse;
    @OneToMany
    @JoinColumn(name = "comment_fk")
    private List<Comment> comments;
    @Temporal(TemporalType.TIME)
    @Column(name = "heureOuverture")
    private Date ouverture;
    @Temporal(TemporalType.TIME)
    @Column(name = "heureFermeture")
    private Date fermeture;
    @Column(name = "email",unique = true,nullable = true)
    @Email
    private String email;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotels)) {
            return false;
        }
        Hotels other = (Hotels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hotels[ id=" + id + " ]";
    }
    
}
