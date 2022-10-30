package dao.Impl.MongoDB;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import connections.Connection;
import dao.Interfaces.ICategorieDao;
import entities.Categorie;
import lombok.NoArgsConstructor;
import mappers.ObjectJSONMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// implementation pour MongoDB
@NoArgsConstructor
public class CategorieDaoImpl implements ICategorieDao {

    @Override
    public List<Categorie> findAll() {
        MongoDatabase database = Connection.getDatabase();
        List<Categorie> categories = new ArrayList<>();
        for (String name : database.listCollectionNames()) {
            MongoCollection<Document> collection = database.getCollection(name);
            Document document = collection.find().first();
            Categorie categorie = ObjectJSONMapper.categorielMapped(document);
            System.out.println("--> doc categ" + document);
            System.out.println("-->  categ" + categorie);

            categories.add(categorie);
        }
        return categories;
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
