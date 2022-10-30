package dao.Impl.MongoDB;

import com.mongodb.client.FindIterable;
import connections.Connection;
import dao.Interfaces.IRestaurantDao;
import entities.Pharmacie;
import entities.Restaurant;
import lombok.NoArgsConstructor;
import mappers.ObjectJSONMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// implementation pour MongoDB
@NoArgsConstructor
public class RestaurantDaoImpl implements IRestaurantDao {
    private String COLLECTION_NAME = "restaurants";

    @Override
    public List<Restaurant> findAll() {
        FindIterable<Document> docs = Connection.getCollection(COLLECTION_NAME);
        List<Restaurant> restaurants = new ArrayList<>();
        for(Document document: docs){
            List<Document> documents = (List<Document>)document.get(COLLECTION_NAME);
            for(Document doc: documents){
                Restaurant restaurant = ObjectJSONMapper.restaurantMapped(doc);
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }

    @Override
    public Restaurant findById(int id) {
        return null;
    }

    @Override
    public Restaurant findByName(String name) {
        return null;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return null;
    }

    @Override
    public void delete(Restaurant restaurant) {

    }
}
