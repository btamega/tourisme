/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tamega.attractions;

import java.util.List;

/**
 *
 * @author BOUGARYTAMEGA
 */

public class Site {
  
    private String name;
    private List<Images> images;
    private String description;
    private String localisation;
//    private Affluence affluence;
//    private String hauteur;
//    private String billet;
//    private String superficie;

   
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }
    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }
    public String getLocalisation() { return localisation; }
    public void setLocalisation(String value) { this.localisation = value; }
//    public Affluence getAffluence() { return affluence; }
//    public void setAffluence(Affluence value) { this.affluence = value; }
//    public String getHauteur() { return hauteur; }
//    public void setHauteur(String value) { this.hauteur = value; }
//    public String getBillet() { return billet; }
//    public void setBillet(String value) { this.billet = value; }
//    public String getSuperficie() { return superficie; }
//    public void setSuperficie(String value) { this.superficie = value; }
}
