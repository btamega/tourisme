/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "imgPath")
    private String path;
    @Column(name = "AuctionId")
    private long auctionId;
//    @ManyToOne
//    @JoinColumn(name="AuctionID", nullable = false, insertable = false, updatable = false)
//    @JoinColumns({
//        @JoinColumn(name="AuctionID", referencedColumnName="AuctionID",nullable = false, insertable = false, updatable = false),
//        @JoinColumn(name="id", referencedColumnName="id")
//    })
//    private AuctionEntity auction;
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (auctionId ^ (auctionId >>> 32));
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

   
    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Images that = (Images) o;

        if (!Objects.equals(id, that.id)) return false;
        if (auctionId != that.auctionId) return false;
        return path != null ? path.equals(that.path) : that.path == null;

    }

    @Override
    public String toString() {
        return "entities.Images[ id=" + id + " ]";
    }
    
}
