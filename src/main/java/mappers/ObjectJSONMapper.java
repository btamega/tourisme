package mappers;


import entities.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ObjectJSONMapper {
    public static Attraction attractionMapped(Document document) {
        Attraction attraction = new Attraction();
        attraction.setType((String) document.get("type"));
        attraction.setName((String) document.get("name"));
        attraction.setLocalisation((String) document.get("localisation"));
        attraction.setDescription((String) document.get("description"));

        return attraction;
    }

    public static Bibliotheque bibliothequeMapped(Document document){
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.setName((String) document.get("name"));
        bibliotheque.setLocalisation((String) document.get("localisation"));
        bibliotheque.setSiteweb((String) document.get("siteweb"));
        bibliotheque.setTelephone((String) document.get("telephone"));
        bibliotheque.setEmail((String) document.get("email"));
        bibliotheque.setOuverture((String) document.get("ouverture"));
        bibliotheque.setDescription((String) document.get("description"));

        return bibliotheque;
    }

    public static Categorie categorielMapped(Document document){
        Categorie categorie = new Categorie();
        categorie.setName((String) document.get("category"));
        categorie.setCouverture((String) document.get("image"));

        return categorie;
    }

    public static Comment commentMapped(Document document){
        Comment comment = new Comment();
        User user = userMapped((Document) document.get("user"));
        comment.setUser(user);
        comment.setContent((String) document.get("content"));
        comment.setDate((String) document.get("date"));

        return comment;
    }

    public static Hopital hopitalMapped(Document document){
        Hopital hopital = new Hopital();
        hopital.setName((String) document.get("name"));
        hopital.setLocalisation((String) document.get("localisation"));
        hopital.setSiteweb((String) document.get("siteweb"));
        hopital.setTelephone((String) document.get("telephone"));
        hopital.setType((String) document.get("type"));
        hopital.setImage((String) document.get("image"));

        return hopital;
    }

    public static Hotel hotelMapped(Document document){
        Hotel hotel = new Hotel();
        hotel.setName((String) document.get("name"));
        hotel.setLocalisation((String) document.get("localisation"));
        hotel.setDescription((String) document.get("description"));
        hotel.setTelephone((String) document.get("telephone"));
        hotel.setTarif((String) document.get("tarif"));
        hotel.setImage((String) document.get("image"));

        return hotel;
    }

    public static Pharmacie pharmacieMapped(Document document){
        Pharmacie pharmacie = new Pharmacie();
        pharmacie.setName((String) document.get("name"));
        pharmacie.setLocalisation((String) document.get("localisation"));
        pharmacie.setQuartier((String) document.get("quartier"));
        pharmacie.setTelephone((String) document.get("telephone"));
        List<Pharmacien> pharmaciens = new ArrayList();
        List<Document> pharmaciensL = (List<Document>) document.get("pharmaciens");
        for(Document docPharmacien : pharmaciensL){
            Pharmacien pharmacien = pharmacienMapped(docPharmacien);
            pharmaciens.add(pharmacien);
        }

        pharmacie.setPharmaciens(pharmaciens);

        return pharmacie;
    }

    public static Pharmacien pharmacienMapped(Document document){
        Pharmacien pharmacien = new Pharmacien();
        pharmacien.setName((String) document.get("name"));
        return pharmacien;
    }

    public static Restaurant restaurantMapped(Document document){
        Restaurant restaurant = new Restaurant();
        restaurant.setName((String) document.get("name"));
        restaurant.setImage((String) document.get("image"));
        restaurant.setLocalisation((String) document.get("localisation"));
        restaurant.setTelephone((String) document.get("telephone"));
        restaurant.setOuverture((String) document.get("ouverture"));
        restaurant.setDescription((String) document.get("description"));
        restaurant.setSiteweb((String) document.get("siteweb"));

        return restaurant;
    }

    public static User userMapped(Document document){
        User user = new User();
        user.setUsername((String) document.get("username"));
        user.setPassword((String) document.get("password"));

        return user;
    }

}
