/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Attractions;
import entities.Bibliotheque;
import entities.Categorie;
import entities.Hopital;
import entities.Hotel;
import interfaces.IAttractions;
import interfaces.IBibliotheque;
import interfaces.IHopital;
import interfaces.IHotel;
import interfaces.Itourisme;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author BOUGARYTAMEGA
 */
@ManagedBean
public class BeanEJB implements Serializable{
    @EJB
    private Attractions attraction;
    @EJB
    private Itourisme ressource;
    @EJB
    private IBibliotheque bibliotheque;
    @EJB
    private IHopital hopitals;
    @EJB
    private IHotel hotels;
    
    
    public List<Categorie> displayCategorie(){
         
        try {
            return ressource.getCategories();
        } catch (RemoteException e) {
            Logger.getLogger(BeanEJB.class.getName()).log(Level.SEVERE, null, e);
             return new ArrayList<>();
        }
       
    }
    
    public List<Bibliotheque> getBibliotheques(){
        try {
            return bibliotheque.getBibliotheques();
        } catch (RemoteException e) {
            Logger.getLogger(BeanEJB.class.getName()).log(Level.SEVERE, null, e);
            return new ArrayList<>();
        }
    }
    
    
    public List<Hotel> getHotels(){
        try {
            return hotels.getHotels();
        } catch (RemoteException e) {
            Logger.getLogger(BeanEJB.class.getName()).log(Level.SEVERE, null, e);
            return new ArrayList<>();
        }
    }
    
    public List<Hopital> getHopitaux(){
        try {
            return hopitals.getHopitaux();
        } catch (RemoteException e) {
            Logger.getLogger(BeanEJB.class.getName()).log(Level.SEVERE, null, e);
            return new ArrayList<>();
        }
    }
    
     
    /*
    public List<Attractions> affiche(){
       
        try {
            return attraction.findAll();
        } catch (RemoteException ex) {
            Logger.getLogger(BeanEJB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }*/
   
}
