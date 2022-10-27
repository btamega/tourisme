
package entities;

import Mapping.ObjectMapping;
import interfaces.IAttractions;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Local(IAttractions.class)
@Stateless
public class Attractions implements IAttractions,AutoCloseable{
     private static final Driver driver=Connection.Connection.ConnectToNeo4j();
    private String type;
    private String name;
    private String description;
    private String localisation;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Attractions() {
        super();
    }

    public Attractions(String type, String name, String description, String localisation) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.localisation = localisation;
    }
    

    @Override
    public List<Attractions> getAttractions() throws RemoteException {
        List<Attractions> attractions;
        try(Session session = driver.session()){
            Result result=session.run("MATCH (n:Attractions) RETURN n.name,n.type,n.description,n.localisation");
            attractions=ObjectMapping.attractionMapped(result);
            System.out.println(attractions.get(0));
        return attractions;
        }
        
    }

    @Override
    public void createAttractions(String type, String name, String description, String localisation) throws RemoteException {
        try(Session session = driver.session()){
            session.run("CREATE (n:"+type+" {type: \""+type+"\",name: \""+name+"\", description: \""+description+"\", localisation: \""+localisation+"\"})");
            System.out.println("Attraction "+name+" créée avec succès");
        }
    }
    @Override
    public void deleteAttraction(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attractions getAttractionById(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Attractions> getAttractionsByName(String name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public List<Attractions> findAll(){
        try(Session session = driver.session()){
            Result result = session.run("MATCH (n:Attractions) RETURN n.name,n.type,n.description,n.localisation");
            List<Attractions> attractions = ObjectMapping.attractionMapped(result);
            return attractions;
        }
    }

}
