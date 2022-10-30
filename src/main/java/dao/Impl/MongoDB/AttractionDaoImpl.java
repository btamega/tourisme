package dao.Impl.MongoDB;

import com.mongodb.client.FindIterable;
import connections.Connection;
import dao.Interfaces.IAttractionDao;
import entities.Attraction;
import entities.Bibliotheque;
import lombok.NoArgsConstructor;
import mappers.ObjectJSONMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// implementation pour MongoDB
@NoArgsConstructor
public class AttractionDaoImpl implements IAttractionDao {
    private String COLLECTION_NAME = "sites";

    @Override
    public List<Attraction> findAll() {
        FindIterable<Document> docs = Connection.getCollection(COLLECTION_NAME);
        List<Attraction> attractions = new ArrayList<>();
        for(Document document: docs){
            List<Document> AttractionD = (List<Document>)document.get(COLLECTION_NAME);
            for(Document doc: AttractionD){
                Attraction attraction = ObjectJSONMapper.attractionMapped(doc);
                attractions.add(attraction);
            }
        }
        return attractions;
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
