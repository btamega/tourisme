/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import Utils.Util;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

/**
 *
 * @author KANNOUFA
 */
public class Connection {
    
    public static MongoDatabase getDatabase(){
        MongoClient mongoClient = MongoClients.create(Util.CONNECTION_STRING);
        MongoDatabase database = mongoClient.getDatabase(Util.DB_NAME);
        
        return database;
    }

    
    public static FindIterable getCollection(String collectionName){
        
        MongoDatabase database = getDatabase();
        
        MongoCollection<Document> collection = database.getCollection(collectionName);
        
        FindIterable<Document> docs = collection.find();
        
        return docs;
    }
    
    public static Driver ConnectToNeo4j(){
         Driver driver=GraphDatabase.driver(Util.URI, AuthTokens.basic(Util.USER, Util.PASSWORD));
         return driver;
    }
    
}
