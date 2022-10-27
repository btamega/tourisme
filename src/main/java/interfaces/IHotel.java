/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Bibliotheque;
import entities.Hotel;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IHotel {
    public List<Hotel> getHotels() throws RemoteException;
    public Hotel getHotel(String Name) throws RemoteException;
    public Hotel addHotel(Hotel hotel) throws RemoteException;
}
