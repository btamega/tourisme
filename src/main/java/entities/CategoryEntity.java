/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Entity
@Data
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CategoryID")
    private int id;
    @Column(name = "CategoryName")
    private String categoryName;
    

    @Override
    public int hashCode() {
       int result = id;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public String toString() {
       return "CategoryEntity{" +
                "categoryId=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
    
}
