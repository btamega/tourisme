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
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.bson.Document;
import com.mycompany.tourisme.Images;
import com.mycompany.tourisme.Site;

/**
 *
 * @author BOUGARYTAMEGA
 */
@ManagedBean
public class RessourceBean {
    public List<Site> affiche(){
        System.out.println("Test");
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
        System.out.println(sitesList.size());
        return sitesList;
    }
    public void createRess(){
        
    }
}
