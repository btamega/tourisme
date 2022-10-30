package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.IHotelDao;
import entities.Bibliotheque;
import entities.Hopital;
import entities.Hotel;
import lombok.NoArgsConstructor;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;


// implémentation pour NEO4J
@NoArgsConstructor
public class HotelDaoImpl implements IHotelDao {
    private static final Driver driver= Connection.ConnectToNeo4j();

    @Override
    public List<Hotel> findAll()  {
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Ressource) WHERE a.category='hotel' RETURN " +
                    "a.name," +
                    "a.localisation," +
                    " a.description," +
                    "a.telephone," +
                    "a.tarif," +
                    "a.image"
            );
            List<Hotel> hotels = ObjectGraphMapper.HotelMapped(result);
            return hotels;
        }
    }

    @Override
    public Hotel findById(int id) {
        return null;
    }

    @Override
    public Hotel findByName(String name) {
        return null;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel update(Hotel hotel) {
        return null;
    }

    @Override
    public void delete(Hotel hotel) {

    }
}
