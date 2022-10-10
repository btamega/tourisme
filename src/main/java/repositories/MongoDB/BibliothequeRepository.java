/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.MongoDB;

import Connection.MongoDBConnection;
import Mapping.ObjectMapping;
import com.mongodb.client.FindIterable;
import entities.Bibliotheque;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author dell
 */
public class BibliothequeRepository {
    public List<Bibliotheque> findAll() {
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
