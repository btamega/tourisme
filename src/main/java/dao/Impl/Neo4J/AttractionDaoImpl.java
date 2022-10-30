package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.IAttractionDao;
import entities.Attraction;
import entities.Bibliotheque;
import lombok.NoArgsConstructor;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;


// implémentation pour NEO4J
@NoArgsConstructor
public class AttractionDaoImpl implements IAttractionDao {
    private static final Driver driver= Connection.ConnectToNeo4j();

    @Override
    public List<Attraction> findAll() {
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Ressource) WHERE a.category='attraction' RETURN " +
                    "a.type," +
                    "a.name," +
                    " a.description," +
                    "a.localisation"
            );
            List<Attraction> attractions = ObjectGraphMapper.AttractionMapped(result);
            return attractions;
        }
    }

    @Override
    public Attraction findById(int id) {
        return null;
    }

    @Override
    public Attraction findByName(String name) {
        return null;
    }

    @Override
    public Attraction save(Attraction attraction) {
        return null;
    }

    @Override
    public Attraction update(Attraction attraction) {
        return null;
    }

    @Override
    public void delete(Attraction attraction) {

    }
}
