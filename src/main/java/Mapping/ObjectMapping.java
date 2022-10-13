/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapping;

import entities.Bibliotheque;
import entities.Categorie;
import entities.Comment;
import entities.Hopital;
import entities.Hotel;
import entities.Pharmacie;
import entities.Pharmacien;
import entities.Restaurant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author dell
 */
public class ObjectMapping {
    
    public static Bibliotheque bibliothequeMapped(Document document){
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.setName((String) document.get("name"));
        bibliotheque.setLocalisation((String) document.get("localisation"));
        bibliotheque.setSiteweb((String) document.get("siteweb"));
        bibliotheque.setTelephone((String) document.get("telephone"));
        bibliotheque.setEmail((String) document.get("email"));
        bibliotheque.setOuverture((String) document.get("ouverture"));
        bibliotheque.setDescription((String) document.get("description"));
        
        return bibliotheque;
    }
    
    public static Pharmacie pharmacieMapped(Document document){
        Pharmacie pharmacie = new Pharmacie();
        pharmacie.setName((String) document.get("name"));
        pharmacie.setLocalisation((String) document.get("localisation"));
        pharmacie.setQuartier((String) document.get("quartier"));
        pharmacie.setTelephone((String) document.get("telephone"));
        List<Pharmacien> pharmaciens = new ArrayList();
        List<Document> pharmaciensL = (List<Document>) document.get("pharmaciens");
        for(Document docPharmacien : pharmaciensL){
            Pharmacien pharmacien = pharmacienMapped(docPharmacien);
            pharmaciens.add(pharmacien);
        }
        
        pharmacie.setPharmaciens(pharmaciens);
         
        return pharmacie;
    }
    
    public static Pharmacien pharmacienMapped(Document document){
        Pharmacien pharmacien = new Pharmacien();
        pharmacien.setName((String) document.get("name"));
        return pharmacien;
    }
    
    public static Hopital hopitalMapped(Document document){
        Hopital hopital = new Hopital();
        hopital.setName((String) document.get("name"));
        hopital.setLocalisation((String) document.get("localisation"));
        hopital.setSiteweb((String) document.get("siteweb"));
        hopital.setTelephone((String) document.get("telephone"));
        hopital.setType((String) document.get("type"));
        hopital.setImage((String) document.get("image"));
        
        return hopital;
    }
    
    public static Categorie categorielMapped(Document document){
        Categorie categorie = new Categorie();
        categorie.setName((String) document.get("category"));
        categorie.setImage((String) document.get("image"));
        categorie.setSize(10);    ////////// à modifier
        
        return categorie;
    }
    
    public static Restaurant restaurantMapped(Document document){
        Restaurant restaurant = new Restaurant();
        restaurant.setName((String) document.get("name"));
        restaurant.setImage((String) document.get("image"));
        restaurant.setLocalisation((String) document.get("localisation"));
        restaurant.setTelephone((String) document.get("telephone"));
        restaurant.setOuverture((String) document.get("ouverture"));
        restaurant.setDescription((String) document.get("description"));
        restaurant.setSiteweb((String) document.get("siteweb"));
                
        return restaurant;
    }
    
    public static Comment commentMapped(Document document){
        Comment comment = new Comment();
        comment.setUsernamme((String) document.get("username"));
        comment.setMessage((String) document.get("message"));
        
        return comment;
    }
    
    public static Hotel hotelMapped(Document document){
        Hotel hotel = new Hotel();
        hotel.setName((String) document.get("name"));
        hotel.setLocalisation((String) document.get("localisation"));
        hotel.setDescription((String) document.get("description"));
        hotel.setTelephone((String) document.get("telephone"));
        hotel.setTarif((String) document.get("tarif"));
        hotel.setImage((String) document.get("image"));
        
        return hotel;
    }
    
}
