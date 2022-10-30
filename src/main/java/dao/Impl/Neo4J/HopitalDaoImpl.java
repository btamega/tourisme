package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.IHopitalDao;
import entities.Bibliotheque;
import entities.Hopital;
import lombok.NoArgsConstructor;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;


// implémentation pour NEO4J
@NoArgsConstructor
public class HopitalDaoImpl implements IHopitalDao {
    private static final Driver driver= Connection.ConnectToNeo4j();

    @Override
    public List<Hopital> findAll(){
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Ressource) WHERE a.category='hopital' RETURN " +
                    "a.name," +
                    "a.localisation," +
                    " a.siteweb," +
                    "a.telephone," +
                    "a.type," +
                    "a.image"
            );
            List<Hopital> hopitals = ObjectGraphMapper.HopitalMapped(result);
            return hopitals;
        }
    }

    @Override
    public Hopital findById(int id) {
        return null;
    }

    @Override
    public Hopital findByName(String name) {
        return null;
    }

    @Override
    public Hopital save(Hopital hopital) {
        return null;
    }

    @Override
    public Hopital update(Hopital hopital) {
        return null;
    }

    @Override
    public void delete(Hopital hopital) {

    }
}
