package dao.Impl.MongoDB;

import com.mongodb.client.FindIterable;
import connections.Connection;
import dao.Interfaces.IHotelDao;
import entities.Hotel;
import lombok.NoArgsConstructor;
import mappers.ObjectJSONMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// implementation pour MongoDB
@NoArgsConstructor
public class HotelDaoImpl implements IHotelDao {
    private String COLLECTION_NAME = "hotels";

    @Override
    public List<Hotel> findAll() {
        FindIterable<Document> docs = Connection.getCollection(COLLECTION_NAME);
        List<Hotel> hotels = new ArrayList<>();
        for(Document document: docs){
            List<Document> documents = (List<Document>)document.get(COLLECTION_NAME);
            for(Document doc: documents){
                Hotel hotel = ObjectJSONMapper.hotelMapped(doc);
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    @Override
    public Hotel findById(int id) {
        return null;
    }

    @Override
    public Hotel findByName(String name) {
        return null;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel update(Hotel hotel) {
        return null;
    }

    @Override
    public void delete(Hotel hotel) {

    }
}
