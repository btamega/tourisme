/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import Mapping.ObjectGraphMapper;
import Mapping.ObjectMapping;
import interfaces.IAttractions;
import interfaces.IBibliotheque;
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
 * @author KANNOUFA
 */
@Local(IAttractions.class)
@Stateless
@Data @NoArgsConstructor @AllArgsConstructor
public class Bibliotheque implements IBibliotheque,AutoCloseable{
    private static final Driver driver=Connection.Connection.ConnectToNeo4j();
    private String name;
    private String localisation;
    private String siteweb;
    private String telephone;
    private String email;
    private String ouverture;
    private String description;

    @Override
    public List<Bibliotheque> getBibliotheques() throws RemoteException {
     try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Bibliotheque) RETURN a ORDER BY a.name");
            List<Bibliotheque> bibliotheques = ObjectGraphMapper.BiblioMapped(result);
            return bibliotheques;
        }   
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bibliotheque getBibliotheque(String Name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bibliotheque addBibliotheque(Bibliotheque bibliotheque) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}