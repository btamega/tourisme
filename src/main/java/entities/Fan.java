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
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class Fan extends UserEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="ActorsFollowed",
            joinColumns= @JoinColumn(name="fan_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name= "actor_id", referencedColumnName="id"))
    private List<Actor> actorsFollowed;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="CriticsFollowed",
            joinColumns= @JoinColumn(name="fan_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name= "id", referencedColumnName="id"))
    private List<Critic> criticsFollowed;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Likes",
            joinColumns= @JoinColumn(name="fan_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name= "attraction_id", referencedColumnName="id"))
    private List<Attractions> likesAttractions;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Dislikes",
            joinColumns = @JoinColumn(name = "fan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id", referencedColumnName = "id"))
    private List<Attractions> dislikesMovies;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Fan> followingFans;
    @ManyToMany(mappedBy = "followingFans", cascade = CascadeType.ALL)
    private List<Fan> followedByFans;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fan)) {
            return false;
        }
        Fan other = (Fan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fan[ id=" + id + " ]";
    }
    
}
