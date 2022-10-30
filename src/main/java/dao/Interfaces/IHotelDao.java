package dao.Interfaces;

import entities.Hotel;

import java.util.List;

public interface IHotelDao {
    public List<Hotel> findAll();
    public Hotel findById(int id);
    public Hotel findByName(String name);
    public Hotel save(Hotel hotel);
    public Hotel update(Hotel hotel);
    public void delete(Hotel hotel);
}
