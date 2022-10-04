/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import com.mongodb.client.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author BOUGARYTAMEGA
 */
public class Connection {
   

/*
 * Requires the MongoDB Java Driver.
 * https://mongodb.github.io/mongo-java-driver
 */
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
        MongoDatabase database = mongoClient.getDatabase("tourisme");
        MongoCollection<Document> collection = database.getCollection("ressources");
        FindIterable<Document> docs = collection.find();
        for( Document doc :docs){
                    System.out.println(" Le pays est "+ doc.get("name")); 
        }
    }

}
