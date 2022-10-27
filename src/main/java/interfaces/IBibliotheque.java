/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

<<<<<<< HEAD
=======
import entities.Bibliotheque;
import java.rmi.RemoteException;
import java.util.List;

>>>>>>> 5774de1cd47e706ef21ebad5734b5f7a9eed989a
/**
 *
 * @author BOUGARYTAMEGA
 */
public interface IBibliotheque {
<<<<<<< HEAD
    
=======
    public List<Bibliotheque> getBibliotheques() throws RemoteException;
    public Bibliotheque getBibliotheque(String Name) throws RemoteException;
    public Bibliotheque addBibliotheque(Bibliotheque bibliotheque) throws RemoteException;
>>>>>>> 5774de1cd47e706ef21ebad5734b5f7a9eed989a
}
