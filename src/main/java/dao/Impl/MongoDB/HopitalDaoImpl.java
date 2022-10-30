package dao.Impl.MongoDB;

import com.mongodb.client.FindIterable;
import connections.Connection;
import dao.Interfaces.IHopitalDao;
import entities.Attraction;
import entities.Hopital;
import lombok.NoArgsConstructor;
import mappers.ObjectJSONMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// implementation pour MongoDB
@NoArgsConstructor
public class HopitalDaoImpl implements IHopitalDao {
    private String COLLECTION_NAME = "hopitaux";

    @Override
    public List<Hopital> findAll() {
        FindIterable<Document> docs = Connection.getCollection(COLLECTION_NAME);
        List<Hopital> hopitaux = new ArrayList<>();
        for(Document document: docs){
            List<Document> documents = (List<Document>)document.get(COLLECTION_NAME);
            for(Document doc: documents){
                Hopital hopital = ObjectJSONMapper.hopitalMapped(doc);
                hopitaux.add(hopital);
            }
        }
        return hopitaux;
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
