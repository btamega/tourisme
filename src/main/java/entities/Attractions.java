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
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Data
@Entity
public class Attractions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ville")
    private String ville;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "couverture")
    private String couverture;
    @Column(name = "heureOuverture")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date heureOuverture;
    @Column(name = "heureFermeture")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date heureFermeture;
    @Column(name = "site")
    private String site;
    
    



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attractions)) {
            return false;
        }
        Attractions other = (Attractions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Attractions[ id=" + id + " ]";
    }
    
}
