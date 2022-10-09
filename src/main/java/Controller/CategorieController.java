/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.MongoDBConnection;
import Mapping.ObjectMapping;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entities.Categorie;
import entities.Images;
import entities.Pharmacie;
import entities.Site;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.bson.Document;

/**
 *
 * @author dell
 */
@ManagedBean
public class CategorieController {
    
    
    public List<Categorie> getCategories(){
        MongoDatabase database = MongoDBConnection.getDatabase();
        List<Categorie> categories = new ArrayList<>();
        for (String name : database.listCollectionNames()) {
            MongoCollection<Document> collection = database.getCollection(name);
            Document document = collection.find().first();
            Categorie categorie = ObjectMapping.categorielMapped(document);
            categories.add(categorie);
        }
        return categories;
    }
    
    
    public List<Pharmacie> getPharmacies(){
        FindIterable<Document> docs = MongoDBConnection.getCollection("pharmacie");
        
        List<Pharmacie> pharmacies = new ArrayList<>();
        System.out.println("------------------- PHARMACIES -----------------------");
        for( Document document :docs){
            Pharmacie pharmacie = ObjectMapping.pharmacieMapped(document);
            System.out.println(pharmacie.toString());
            pharmacies.add(pharmacie);
        }
        return pharmacies;
    }
    
}
