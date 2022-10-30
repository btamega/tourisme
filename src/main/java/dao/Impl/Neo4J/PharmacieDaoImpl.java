package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.IPharmacieDao;
import entities.Bibliotheque;
import entities.Hotel;
import entities.Pharmacie;
import lombok.NoArgsConstructor;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;


// implémentation pour NEO4J
@NoArgsConstructor
public class PharmacieDaoImpl implements IPharmacieDao {
    private static final Driver driver= Connection.ConnectToNeo4j();

    @Override
    public List<Pharmacie> findAll() {
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Ressource) WHERE a.category='pharmacie' RETURN " +
                    "a.name," +
                    "a.localisation," +
                    "a.quartier," +
                    "a.telephone"
            );
            List<Pharmacie> pharmacies = ObjectGraphMapper.PharmacieMapped(result);
            return pharmacies;
        }
    }

    @Override
    public Pharmacie findById(int id) {
        return null;
    }

    @Override
    public Pharmacie findByName(String name) {
        return null;
    }

    @Override
    public Pharmacie save(Pharmacie pharmacie) {
        return null;
    }

    @Override
    public Pharmacie update(Pharmacie pharmacie) {
        return null;
    }

    @Override
    public void delete(Pharmacie pharmacie) {

    }
}
