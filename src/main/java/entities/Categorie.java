/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;


import Mapping.ObjectMapping;
import interfaces.Itourisme;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

/**
 *
 * @author dell
 */

@Data @NoArgsConstructor @AllArgsConstructor
@Local(Itourisme.class)
@Stateless
public class Categorie implements Itourisme,AutoCloseable{
     private static final Driver driver=Connection.Connection.ConnectToNeo4j();
    
    
 
    //@Property(name="name")
    private String name;

   
    private String couverture;

    @Override
    public List<Categorie> getCategories() throws RemoteException {
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Category) RETURN a.name,a.imaege ORDER BY a.name");
            List<Categorie> attractions = ObjectMapping.getCategories(result);
            return attractions;
        }
        }

    @Override
    public List<String> getUser() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteRessource() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

   
}
