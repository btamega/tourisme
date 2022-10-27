/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapping;

import entities.Attractions;
import entities.Bibliotheque;
import entities.Hopital;
import entities.Hotel;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;

/**
 *
 * @author dell
 */
public class ObjectGraphMapper {
    
    public static List<Bibliotheque> BiblioMapped(Result result){
        List<Record> records = result.list();
       List<Bibliotheque> bibliotheques = new ArrayList<>();
        for (Record record : records) {
                bibliotheques.add(
                        new Bibliotheque(
                            record.get("name").asString(),
                            record.get("description").asString(),
                            record.get("localisation").asString(),
                            record.get("siteweb").asString(),
                            record.get("telephone").asString(),
                            record.get("email").asString(),
                            record.get("ouverture").asString()
                        ));
            }
        return bibliotheques;
    }
    
    public static List<Hopital> HopitalMapped(Result result){
        List<Record> records = result.list();
       List<Hopital> hopitaux = new ArrayList<>();
        for (Record record : records) {
                hopitaux.add(
                        new Hopital(
                            record.get("name").asString(),
                            record.get("localisation").asString(),
                            record.get("siteweb").asString(),
                            record.get("telephone").asString(),
                            record.get("type").asString(),
                            record.get("image").asString()
                        ));
            }
        return hopitaux;
    }
    
    public static List<Hotel> HotelMapped(Result result){
        List<Record> records = result.list();
       List<Hotel> hotels = new ArrayList<>();
        for (Record record : records) {
                hotels.add(
                        new Hotel(
                            record.get("name").asString(),
                            record.get("description").asString(),
                            record.get("localisation").asString(),
                            record.get("tarif").asString(),
                            record.get("telephone").asString(),
                            record.get("image").asString()
                        ));
            }
        return hotels;
    }
}