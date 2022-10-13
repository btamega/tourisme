/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.MongoDBConnection;
import Mapping.ObjectMapping;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.elemMatch;
import static com.mongodb.client.model.Filters.eq;
import entities.Bibliotheque;
import entities.Categorie;
import entities.Hopital;
import entities.Hotel;
import entities.Pharmacie;
import entities.Restaurant;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Data;
import org.bson.Document;

/**
 *
 * @author dell
 */
@Data
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
        FindIterable<Document> docs = MongoDBConnection.getCollection("pharmacies");
        List<Pharmacie> pharmacies = new ArrayList<>();
        for(Document document: docs){
            List<Document> pharmacieD = (List<Document>)document.get("pharmacies");
            for(Document doc: pharmacieD){
                Pharmacie pharmacie = ObjectMapping.pharmacieMapped(doc);
                pharmacies.add(pharmacie);
            }  
        }
        return pharmacies;
    }
    
        
    public List<Hotel> getHotels(){
        FindIterable<Document> docs = MongoDBConnection.getCollection("hotels");
        List<Hotel> hotels = new ArrayList<>();
        for(Document document: docs){
            List<Document> hotelD = (List<Document>)document.get("hotels");
            for(Document doc: hotelD){
                Hotel hotel = ObjectMapping.hotelMapped(doc);
                hotels.add(hotel);
            }  
        }
        return hotels;
    }
    
    public List<Hopital> getHopitaux(){
        FindIterable<Document> docs = MongoDBConnection.getCollection("hopitaux");
        List<Hopital> hopitaux = new ArrayList<>();
        for(Document document: docs){
            List<Document> hopitalD = (List<Document>)document.get("hopitaux");
            for(Document doc: hopitalD){
                Hopital hopital = ObjectMapping.hopitalMapped(doc);
                hopitaux.add(hopital);
            }  
        }
        return hopitaux;
    }
    
    public List<Restaurant> getRestaurants(){
        FindIterable<Document> docs = MongoDBConnection.getCollection("restaurants");
        List<Restaurant> restaurants = new ArrayList<>();
        for(Document document: docs){
            List<Document> restaurantD = (List<Document>)document.get("restaurants");
            for(Document doc: restaurantD){
                Restaurant restaurant = ObjectMapping.restaurantMapped(doc);
                restaurants.add(restaurant);
            }  
        }
        return restaurants;
    }
    
    public List<Bibliotheque> getBibliotheques(){
        FindIterable<Document> docs = MongoDBConnection.getCollection("bibliotheques");
        List<Bibliotheque> bibliotheques = new ArrayList<>();
        for(Document document: docs){
            List<Document> bibliothequeD = (List<Document>)document.get("bibliotheques");
            for(Document doc: bibliothequeD){
                Bibliotheque bibliotheque = ObjectMapping.bibliothequeMapped(doc);
                bibliotheques.add(bibliotheque);
            }  
        }
        System.out.println("-----------> biblios");
        return bibliotheques;
    }
    
    public Bibliotheque getFirst(){
        Bibliotheque bibliotheque = new Bibliotheque();
        FindIterable<Document> docs = MongoDBConnection.getCollection("bibliotheques");
        
        return bibliotheque;
    }
    
    public Bibliotheque findById(int index){
        MongoDatabase database = MongoDBConnection.getDatabase();
        MongoCollection<Document> biblioCollection = database.getCollection("bibliotheques");
        
        Document document = biblioCollection.find().projection(elemMatch("bibliotheques",new Document("_id", index))).first();

        Bibliotheque biblio = ObjectMapping.bibliothequeMapped(document);
        
        return biblio;
    }
    
    public Bibliotheque findByName(String name){
        MongoDatabase database = MongoDBConnection.getDatabase();
        MongoCollection<Document> biblioCollection = database.getCollection("bibliotheques");
        
        Document document = biblioCollection.find().projection(elemMatch("bibliotheques",new Document("name", name))).first();
        
        Bibliotheque bibliotheque = ObjectMapping.bibliothequeMapped(document);
        
        return bibliotheque;
    }
    
    
    public Restaurant findRestaurantByName(String name){
        MongoDatabase database = MongoDBConnection.getDatabase();
        MongoCollection<Document> restauCollection = database.getCollection("restaurants");
        
        Document document = restauCollection.find().projection(elemMatch("restaurants",new Document("name", name))).first();
        System.out.println("-----> findRestaurantByName : " + document);
        
        Restaurant restaurant = ObjectMapping.restaurantMapped(document);
        
        return restaurant;
    }

}
