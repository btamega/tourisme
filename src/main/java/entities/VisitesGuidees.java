/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import interfaces.IVisitesGuidees;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
<<<<<<< HEAD
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
=======
>>>>>>> 5774de1cd47e706ef21ebad5734b5f7a9eed989a

/**
 *
 * @author BOUGARYTAMEGA
 */
@Local(IVisitesGuidees.class)
@Stateless
public class VisitesGuidees implements IVisitesGuidees{
    private String titre;
    private String description;
    private Guide guide;
    private List<String> image;
    private Double cost;
    private String duree;
<<<<<<< HEAD
private static final Driver driver=Connection.Connection.ConnectToNeo4j();
=======

>>>>>>> 5774de1cd47e706ef21ebad5734b5f7a9eed989a
    public VisitesGuidees() {
        super();
    }
    @Override
    public List<VisitesGuidees> getSites() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public VisitesGuidees(String titre, String description, Guide guide, List<String> image, Double cost, String duree) {
        this.titre = titre;
        this.description = description;
        this.guide = guide;
        this.image = image;
        this.cost = cost;
        this.duree = duree;
    }

    @Override
    public void createRessourceVisites() throws RemoteException {
<<<<<<< HEAD
        try(Session session = driver.session()){
            session.run("CREATE (n:VisitesGuidees {description: 'Andy', title: 'Developer'})");
        }
=======
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
>>>>>>> 5774de1cd47e706ef21ebad5734b5f7a9eed989a
    }

    @Override
    public void deleteVisite(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VisitesGuidees getVisiteGuideeById(String id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VisitesGuidees> getVisiteGuideesByName(String name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
