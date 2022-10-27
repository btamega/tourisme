/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.VisitesGuidees;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author BOUGARYTAMEGA
 */
public interface IVisitesGuidees {
     public List<VisitesGuidees>getSites() throws RemoteException;
     public void createRessourceVisites() throws RemoteException;
      public void deleteVisite(String id) throws RemoteException;
     public VisitesGuidees getVisiteGuideeById(String id) throws RemoteException;
     public List<VisitesGuidees>getVisiteGuideesByName(String name) throws RemoteException;
}
