package dao.Impl.MongoDB;

import com.mongodb.client.FindIterable;
import connections.Connection;
import dao.Interfaces.IPharmacieDao;
import entities.Hotel;
import entities.Pharmacie;
import lombok.NoArgsConstructor;
import mappers.ObjectJSONMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// implementation pour MongoDB
@NoArgsConstructor
public class PharmacieDaoImpl implements IPharmacieDao {
    private String COLLECTION_NAME = "pharmacies";

    @Override
    public List<Pharmacie> findAll() {
        FindIterable<Document> docs = Connection.getCollection(COLLECTION_NAME);
        List<Pharmacie> pharmacies = new ArrayList<>();
        for(Document document: docs){
            List<Document> documents = (List<Document>)document.get(COLLECTION_NAME);
            for(Document doc: documents){
                Pharmacie pharmacie = ObjectJSONMapper.pharmacieMapped(doc);
                pharmacies.add(pharmacie);
            }
        }
        return pharmacies;
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
