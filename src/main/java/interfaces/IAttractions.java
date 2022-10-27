/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;


import entities.Attractions;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author BOUGARYTAMEGA
 */
public interface IAttractions {
     public List<Attractions>getAttractions() throws RemoteException;
     public void createAttractions(String type, String name, String description, String localisation) throws RemoteException;
     public void deleteAttraction(String id) throws RemoteException;
     public Attractions getAttractionById(String id) throws RemoteException;
     public List<Attractions>getAttractionsByName(String name) throws RemoteException;
    public  List<Attractions> findAll() throws RemoteException;
    
}

