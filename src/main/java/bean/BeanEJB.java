/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Attractions;
import entities.Categorie;
import interfaces.IAttractions;
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
    private IAttractions attraction;
    @EJB
    private Itourisme ressource;
    public List<Categorie> displayCategorie(){
         
        try {
            return ressource.getCategories();
        } catch (RemoteException e) {
            Logger.getLogger(BeanEJB.class.getName()).log(Level.SEVERE, null, e);
             return new ArrayList<>();
        }
       
    }
    public List<Attractions> affiche(){
       
        try {
            return attraction.findAll();
        } catch (RemoteException ex) {
            Logger.getLogger(BeanEJB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
