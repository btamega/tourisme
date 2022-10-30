package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.ICategorieDao;
import entities.Bibliotheque;
import entities.Categorie;
import lombok.NoArgsConstructor;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;


// implémentation pour NEO4J
@NoArgsConstructor
public class CategorieDaoImpl implements ICategorieDao {
    private static final Driver driver= Connection.ConnectToNeo4j();

    @Override
    public List<Categorie> findAll() {
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:Category) RETURN " +
                    "a.name," +
                    "a.couverture"
            );
            List<Categorie> categories = ObjectGraphMapper.CategorieMapped(result);
            return categories;
        }
    }

    @Override
    public Categorie findById(int id) {
        return null;
    }

    @Override
    public Categorie findByName(String name) {
        return null;
    }

    @Override
    public Categorie save(Categorie categorie) {
        return null;
    }

    @Override
    public Categorie update(Categorie categorie) {
        return null;
    }

    @Override
    public void delete(Categorie categorie) {

    }
}
