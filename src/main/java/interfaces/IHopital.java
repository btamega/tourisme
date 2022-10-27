/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Hopital;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IHopital {
    public List<Hopital> getHopitaux() throws RemoteException;
    public Hopital getHopital(String Name) throws RemoteException;
    public Hopital addHopital(Hopital hopital) throws RemoteException;
}
