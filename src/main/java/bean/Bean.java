/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.bson.Document;
import tamega.attractions.Attractions;
import tamega.attractions.Images;
import tamega.attractions.Site;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Named
@RequestScoped
public class Bean {
   

    public List<Site> getSites() { 
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
        MongoDatabase database = mongoClient.getDatabase("tourisme");
        MongoCollection<Document> collection = database.getCollection("ressources");
        
        FindIterable<Document> docs = collection.find();
        List<Site> sitesList = new ArrayList<>();
        
        for( Document doc :docs){
            
            
            Document ressources = (Document) doc.get("ressources");
            List<Document> ressource = (List<Document>) ressources.get("ressource");
             
            
                List<Document> siteList = (List<Document>) ressource.get(0).get("site");
                for (Document document1 : siteList) {
                    Site site = new Site();
                    site.setName((String) document1.get("name"));
                    site.setDescription((String) document1.get("description"));
                    site.setLocalisation((String) document1.get("localisation"));
                    List<Images> images = new ArrayList<>();
                    Document imageList = (Document) document1.get("images");
                    images.add(new Images((String) imageList.get("path")));
                    site.setImages(images);
                    sitesList.add(site);
                    System.out.println(document1.get("name"));
                }
        }
        return sitesList;
    }
}
