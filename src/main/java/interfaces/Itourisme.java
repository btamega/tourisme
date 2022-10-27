/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Categorie;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author BOUGARYTAMEGA
 */
public interface Itourisme {
    public List<Categorie> getCategories() throws RemoteException;
    public List<String> getUser() throws RemoteException;
    public void deleteRessource() throws RemoteException;
   
}
