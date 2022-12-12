/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class Critic extends UserEntity {

   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(mappedBy = "criticsFollowed")
    private List<Fan> fans;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Recommend",
            joinColumns= @JoinColumn(name="critic_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name= "attraction_id", referencedColumnName="id"))
    private List<Attractions> recommendedAttractions;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "criticsFollowed")
    private List<Fan> fansFollowingCritics;
    @OneToMany(mappedBy = "critic",cascade = CascadeType.ALL)
    private List<Review> reviewedAttraction;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Critic)) {
            return false;
        }
        Critic other = (Critic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Critic[ id=" + id + " ]";
    }
    
}
