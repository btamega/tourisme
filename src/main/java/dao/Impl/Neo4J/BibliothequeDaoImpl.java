package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.IBibliothqueDao;
import entities.Attraction;
import entities.Bibliotheque;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;
import lombok.NoArgsConstructor;

// implémentation pour NEO4J
@NoArgsConstructor
public class BibliothequeDaoImpl implements IBibliothqueDao{
    private static final Driver driver= Connection.ConnectToNeo4j();

    public List<Bibliotheque> findAll(){
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Ressource) WHERE a.category='bibliotheque' RETURN " +
                    "a.name," +
                    "a.localisation," +
                    " a.siteweb," +
                    "a.telephone," +
                    "a.email," +
                    "a.ouverture," +
                    "a.description"
            );
            List<Bibliotheque> bibliotheques = ObjectGraphMapper.BibliothequeMapped(result);
            return bibliotheques;
        }
    }

    @Override
    public Bibliotheque findById(int id) {
        return null;
    }

    @Override
    public Bibliotheque findByName(String name) {
        return null;
    }

    @Override
    public Bibliotheque save(Bibliotheque bibliotheque) {
        return null;
    }

    @Override
    public Bibliotheque update(Bibliotheque bibliotheque) {
        return null;
    }

    @Override
    public void delete(Bibliotheque bibliotheque) {

    }

}
