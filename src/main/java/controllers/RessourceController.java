package controllers;


import entities.*;
import lombok.Data;
import services.Impl.*;
import services.Interfaces.*;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Data
@ManagedBean
public class RessourceController {
    private IAttractionService attractionService = new AttractionServiceImpl();
    private IBibliothequeService bibliothequeService = new BibliothequeServiceImpl();
    private ICategorieService categorieService = new CategorieServiceImpl();
    private IHopitalService hopitalService = new HopitalServiceImpl();
    private IHotelService hotelService = new HotelServiceImpl();
    private IPharmacieService pharmacieService = new PharmacieServiceImpl();
    private IRestaurantService restaurantService = new RestaurantServiceImpl();
    
    public List<Attraction> getAttractions(){
        return attractionService.findAll();
    }

    public List<Bibliotheque> getBibliotheques(){
        return bibliothequeService.findAll();
    }

    public List<Categorie> getCategories(){
        return categorieService.findAll();
    }

    public List<Hopital> getHopitaux(){
        return hopitalService.findAll();
    }

    public List<Hotel> getHotels(){
        return hotelService.findAll();
    }

    public List<Pharmacie> getPharmacies(){
        return pharmacieService.findAll();
    }
    
    public List<Restaurant> getRestaurants(){
        return restaurantService.findAll();
    }
}
