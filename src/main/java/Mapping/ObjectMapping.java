/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapping;

import entities.Bibliotheque;
import entities.Categorie;
import entities.Hopital;
import entities.Pharmacie;
import entities.Pharmacien;
import java.util.ArrayList;
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
    
}
