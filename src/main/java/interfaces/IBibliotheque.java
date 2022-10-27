/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Bibliotheque;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author BOUGARYTAMEGA
 */
public interface IBibliotheque {
    public List<Bibliotheque> getBibliotheques() throws RemoteException;
    public Bibliotheque getBibliotheque(String Name) throws RemoteException;
    public Bibliotheque addBibliotheque(Bibliotheque bibliotheque) throws RemoteException;
}
