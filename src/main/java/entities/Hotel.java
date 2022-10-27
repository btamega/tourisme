/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import Mapping.ObjectGraphMapper;
import interfaces.IAttractions;
import interfaces.IBibliotheque;
import interfaces.IHotel;
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
@Local(IAttractions.class)
@Stateless
@Data @NoArgsConstructor @AllArgsConstructor
public class Hotel implements IHotel,AutoCloseable{
    private static final Driver driver=Connection.Connection.ConnectToNeo4j();
    private String name;
    private String localisation;
    private String description;
    private String telephone;
    private String tarif;
    private String image;  

    @Override
    public List<Hotel> getHotels() throws RemoteException {
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Hotel) RETURN a ORDER BY a.name");
            List<Hotel> hotels = ObjectGraphMapper.HotelMapped(result);
            return hotels;
        }   
    }

    @Override
    public Hotel getHotel(String Name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Hotel addHotel(Hotel hotel) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
