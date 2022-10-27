/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import Connection.Connection;
import Mapping.ObjectMapping;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.elemMatch;
import static com.mongodb.client.model.Filters.eq;
import entities.Bibliotheque;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped; 
import javax.inject.Named;
import lombok.Data;
import org.bson.Document;

/**
 *
 * @author dell
 */
@Data
@Named 
@SessionScoped 
public class BibliothequeListener implements Serializable{
   private static final long serialVersionUID = 2729758432756108274L;
   private Bibliotheque bibliotheque = findById(1);
   private int index=1;
   
   public void biblothequeDetails(ActionEvent event){
       index++;
       Bibliotheque biblio = findById(index);
       setBibliotheque(biblio);
   }
   
    public Bibliotheque findById(int index){
        MongoDatabase database = Connection.getDatabase();
        MongoCollection<Document> biblioCollection = database.getCollection("bibliotheques");
        
        Document document = biblioCollection.find().projection(elemMatch("bibliotheques",new Document("_id", index))).first();

        Bibliotheque biblio = ObjectMapping.bibliothequeMapped(document);
        
        return biblio;
    }
   
   public Bibliotheque findByName(String name){
        MongoDatabase database = Connection.getDatabase();
        MongoCollection<Document> biblioCollection = database.getCollection("bibliotheques");
        
        Document document = biblioCollection.find().projection(elemMatch("bibliotheques",new Document("name", name))).first();
        
        Bibliotheque bibliotheque = ObjectMapping.bibliothequeMapped(document);
        
        return bibliotheque;
    }

    
    
    
}
