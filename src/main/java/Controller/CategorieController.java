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
import entities.Bibliotheque;
import entities.Categorie;
import entities.Hopital;
import entities.Pharmacie;
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
        return bibliotheques;
    }
    
}
