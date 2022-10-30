package mappers;

import entities.*;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;

import java.util.ArrayList;
import java.util.List;

public class ObjectGraphMapper {
    public static List<Attraction> AttractionMapped(Result result) {
        List<Record> records = result.list();
        List<Attraction> attractions = new ArrayList<>();
        for (Record record : records) {
            Attraction item = new Attraction();
            item.setType(record.get("a.type").asString());
            item.setName(record.get("a.name").asString());
            item.setDescription(record.get("a.description").asString());
            item.setLocalisation(record.get("a.localisation").asString());
            attractions.add(item);
        }
        return attractions;
    }

    public static List<Bibliotheque> BibliothequeMapped(Result result) {
        List<Record> records = result.list();
        List<Bibliotheque> bibliotheques = new ArrayList<>();
        for (Record record : records) {
            bibliotheques.add(
                    new Bibliotheque(
                            record.get("a.name").asString(),
                            record.get("a.localisation").asString(),
                            record.get("a.siteweb").asString(),
                            record.get("a.telephone").asString(),
                            record.get(".email").asString(),
                            record.get("a.ouverture").asString(),
                            record.get("a.description").asString()
                    ));
        }
        return bibliotheques;
    }

    public static List<Categorie> CategorieMapped(Result result) {
        List<Record> records = result.list();
        List<Categorie> categories = new ArrayList<>();
        for (Record record : records) {
            Categorie item = new Categorie();
            item.setName(record.get("a.name").asString());
            item.setCouverture(record.get("a.couverture").asString());
            categories.add(item);
        }
        return categories;
    }

    public static List<Hopital> HopitalMapped(Result result) {
        List<Record> records = result.list();
        List<Hopital> hopitaux = new ArrayList<>();
        for (Record record : records) {
            Hopital item = new Hopital();
            item.setName(record.get("a.name").asString());
            item.setLocalisation(record.get("a.localisation").asString());
            item.setSiteweb(record.get("a.siteweb").asString());
            item.setTelephone(record.get("a.telephone").asString());
            item.setType(record.get("a.type").asString());
            item.setImage(record.get("a.image").asString());
            hopitaux.add(item);
        }
        return hopitaux;
    }

    public static List<Hotel> HotelMapped(Result result) {
        List<Record> records = result.list();
        List<Hotel> hotels = new ArrayList<>();
        for (Record record : records) {
            Hotel item = new Hotel();
            item.setName(record.get("a.name").asString());
            item.setLocalisation(record.get("a.localisation").asString());
            item.setDescription(record.get("a.description").asString());
            item.setTelephone(record.get("a.telephone").asString());
            item.setTarif(record.get("a.tarif").asString());
            item.setImage(record.get("a.image").asString());
            hotels.add(item);
        }
        return hotels;
    }

    public static List<Pharmacie> PharmacieMapped(Result result) {
        List<Record> records = result.list();
        List<Pharmacie> pharmacies = new ArrayList<>();
        for (Record record : records) {
            Pharmacie item = new Pharmacie();
            item.setName(record.get("a.name").asString());
            item.setLocalisation(record.get("a.localisation").asString());
            item.setQuartier(record.get("a.quartier").asString());
            item.setTelephone(record.get("a.telephone").asString());
            // pharmaciens ...
            pharmacies.add(item);
        }
        return pharmacies;
    }

    public static List<Restaurant> RestaurantMapped(Result result) {
        List<Record> records = result.list();
        List<Restaurant> restaurants = new ArrayList<>();
        for (Record record : records) {
            Restaurant item = new Restaurant();
            item.setName(record.get("a.name").asString());
            item.setImage(record.get("a.image").asString());
            item.setLocalisation(record.get("a.localisation").asString());
            item.setTelephone(record.get("a.telephone").asString());
            item.setOuverture(record.get("a.ouverture").asString());
            item.setDescription(record.get("a.description").asString());
            item.setOuverture(record.get("a.ouverture").asString());
            item.setSiteweb(record.get("a.siteweb").asString());
            restaurants.add(item);
        }
        return restaurants;
    }
}
