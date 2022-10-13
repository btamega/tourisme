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
import entities.Images;
import entities.Site;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.bson.Document;
import java.io.Serializable;
import static java.util.Arrays.asList;
import java.util.Map;
import java.util.Random;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.bson.types.ObjectId;

/**
 *
 * @author BOUGARYTAMEGA
 */
@ManagedBean

public class RessourceBean implements Serializable{
   
    private String categorie;
    private String image;
    private String description;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String createPage(){
        return "create";
    }
     public String deletePage(){
        return "deleteRessource";
    }
     public String getRessources(){
        return "ressources";
    }
    public List<String> categories(){
        List<String> categoryList = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
        MongoDatabase database = mongoClient.getDatabase("tourisme");
        for (String name : database.listCollectionNames()) {
            MongoCollection<Document> collection = database.getCollection(name);
            Document docs = collection.find().first();
            categoryList.add(docs.get("category").toString());
            
        }
        return categoryList;
    }
    public List<Site> affiche(){
    
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
    public void createRessourceVisites(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
            MongoDatabase database= mongoClient.getDatabase("tourisme");
            MongoCollection<Document> gradesCollection = database.getCollection("visitesGuidees");
            Document ressource = new Document("_id", new ObjectId());
            ressource.append("visites", 
                    new Document("titre", "Excursion d'une journée à la découverte du massif de l'Atlas, des trois vallées et des chutes d'eau à dos de chameau au départ de Marrakech")
            .append("guide", new Document("name", "Amzil Marrakech Tickets").append("contact", null)
            ).append("images", new Document("couverture", null).append("path", "resources/images/attractions/visitesGuidees/atlas"))
             .append("description", "Si vous explorez le massif de l'Atlas marocain sans guide, vous pourriez manquer une occasion de découvrir la culture berbère et des points de vue panoramiques. Cependant, la plupart des excursions en groupe suivent des itinéraires fixes qui ne laissent pas de place à la spontanéité pendant la journée. Cette excursion privée est une véritable affaire : un guide local organise la logistique et l'interaction avec les villageois berbères, et vous avez la possibilité de personnaliser votre itinéraire. Un déjeuner local, une promenade facultative à dos de chameau et une visite chez une famille berbère sont tous inclus.")
             .append("cost", 350 +"Dhs")
             .append("duree", 7+"H")
             .append("circuit", new Document("depart", "Marrakech").append("arrivee", "Atlas Mountain Park National De Toubkal").append("duree", 7+"H"))
             .append("avis", new Document("commentaire", new Document("message", "Excellente journée, le guide est tres respectueux et a l'ecoute, bus propre et climatisé explication sur les villes tres clair et pousser en francais et en anglais. Experience a refaire !! merci ilyes")).append("date", "Sep 28 2022").append("user","gastronomes06"))
            )
                   .append("class_id", 1d)
                   ;
            gradesCollection.insertOne(ressource);
    }
    public void createRessource(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
            MongoDatabase database= mongoClient.getDatabase("tourisme");
            database.createCollection(categorie);
            MongoCollection<Document> gradesCollection = database.getCollection(categorie);
            Document ressource = new Document("_id", new ObjectId());
            ressource.append("image", image).append("category", categorie)
                    .append(categorie, asList(new Document("_id", 1).append("name", name) .append("description", description)));
            gradesCollection.insertOne(ressource);
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    private String parameter;
    public void delete(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
        MongoDatabase database= mongoClient.getDatabase("tourisme");
        MongoCollection<Document> collection = database.getCollection(parameter);
        System.out.println("Suppression de la collection "+parameter);
        collection.drop();
    }
}
