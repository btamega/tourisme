package dao.Impl.MongoDB;

import com.mongodb.client.FindIterable;
import connections.Connection;
import dao.Interfaces.IBibliothqueDao;
import entities.Bibliotheque;

import mappers.ObjectJSONMapper;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

// implementation pour MongoDB
@NoArgsConstructor
public class BibliothequeDaoImpl implements IBibliothqueDao{
    private String COLLECTION_NAME = "bibliotheques";

    @Override
    public List<Bibliotheque> findAll(){
        FindIterable<Document> docs = Connection.getCollection(COLLECTION_NAME);
        List<Bibliotheque> bibliotheques = new ArrayList<>();
        for(Document document: docs){
            List<Document> bibliothequeD = (List<Document>)document.get(COLLECTION_NAME);
            for(Document doc: bibliothequeD){
                Bibliotheque bibliotheque = ObjectJSONMapper.bibliothequeMapped(doc);
                bibliotheques.add(bibliotheque);
            }
        }
        return bibliotheques;
    }

    @Override
    public Bibliotheque findById(int id) {
        return null;
    }

    public Bibliotheque findByName(String name){
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
