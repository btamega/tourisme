package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.IRestaurantDao;
import entities.Bibliotheque;
import entities.Pharmacie;
import entities.Restaurant;
import lombok.NoArgsConstructor;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;

// implémentation pour NEO4J
@NoArgsConstructor
public class RestaurantDaoImpl implements IRestaurantDao {
    private static final Driver driver= Connection.ConnectToNeo4j();

    @Override
    public List<Restaurant> findAll()  {
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Ressource) WHERE a.category='restaurant' RETURN " +
                    "a.name," +
                    "a.image," +
                    "a.localisation," +
                    "a.telephone," +
                    "a.ouverture," +
                    "a.description," +
                    "a.siteweb"
            );
            List<Restaurant> restaurants = ObjectGraphMapper.RestaurantMapped(result);
            return restaurants;
        }
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
