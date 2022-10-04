/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static java.util.Arrays.asList;
import java.util.Random;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author BOUGARYTAMEGA
 */
public class Create {
    public static void main(String[] args) {
       System.out.println(" Inside main "); 
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
            MongoDatabase database= mongoClient.getDatabase("test");
            MongoCollection<Document> gradesCollection = database.getCollection("students");
            Random rand = new Random();
            Document student = new Document("_id", new ObjectId());
            student.append("student_id", 10000d)
                   .append("class_id", 1d)
                   .append("scores", asList(new Document("type", "exam").append("score", rand.nextDouble() * 100),
                                new Document("type", "quiz").append("score", rand.nextDouble() * 100),
                    new Document("type", "homework").append("score", rand.nextDouble() * 100),
                    new Document("type", "homework").append("score", rand.nextDouble() * 100)));
            gradesCollection.insertOne(student);
        }
//            Random rand = new Random();
//            Document ressource = new Document("_id", new ObjectId());
//            ressource.append("site", 
//            asList( 
//                new Document("name","Kouroukan fouga" )
//                        .append("image", 
//                                asList(new Document("path","resources/images/attractions/site"))
//                                )
//                        .append("description", "Un site au Mali")
//                    .append("localisation", "Mali")
//                    .append("affluence", 
//                                            asList(new Document("saison", rand)))
//            ))
//                   .append("class_id", 1d)
//                   .append("scores", asList(new Document("type", "exam").append("score", rand.nextDouble() * 100),
//                                            new Document("type", "quiz").append("score", rand.nextDouble() * 100),
//                                            new Document("type", "homework").append("score", rand.nextDouble() * 100),
//                                            new Document("type", "homework").append("score", rand.nextDouble() * 100)));
//
//                    }
    
}
