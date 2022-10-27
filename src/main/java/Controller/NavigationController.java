/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.Connection;
import Mapping.ObjectMapping;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.elemMatch;
import entities.Bibliotheque;
import entities.Hotel;
import entities.Restaurant;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Data;
import org.bson.Document;

/**
 *
 * @author KANNOUFA
 */
@Data
@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
    private Restaurant restaurant;
    private Hotel hotel;

   
    public String goTo(String pageName){
        return pageName;
    }
    
    public String goToRestautant(String restaurantName){
        System.out.println("rest : " + restaurantName);
        
        setRestaurant(findRestaurantByName(restaurantName));
        
        System.out.println("rest db : " + findRestaurantByName("POKA").getName());
        return "restaurant";
    }
    
    public String goToHotel(String hotelName){
        System.out.println("rest : " + hotelName);
        
        setHotel(findHotelByName(hotelName));
        
        System.out.println("rest db : " + findHotelByName("PALAIS NAMASKAR").getName());
        return "hotel";
    }

        
    public Restaurant findRestaurantByName(String name){
        MongoDatabase database = Connection.getDatabase();
        MongoCollection<Document> restauCollection = database.getCollection("restaurants");
        
        Document document = restauCollection.find().projection(elemMatch("restaurants",new Document("name", name))).first();
        
        Restaurant restau = ObjectMapping.restaurantMapped(document);
        
        return restau;
    }
    
    
    public Hotel findHotelByName(String name){
        MongoDatabase database = Connection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("hotels");
        
        Document document = collection.find().projection(elemMatch("hotels",new Document("name", name))).first();
        
        Hotel hot = ObjectMapping.hotelMapped(document);
        
        return hot;
    }
    
}
