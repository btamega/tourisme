package services.Impl;

import dao.Impl.MongoDB.HotelDaoImpl;
import dao.Interfaces.IHotelDao;
import entities.Hotel;
import lombok.NoArgsConstructor;
import services.Interfaces.IHotelService;

import java.util.List;

@NoArgsConstructor
public class HotelServiceImpl implements IHotelService {
    private IHotelDao hotelDao = new HotelDaoImpl();

    @Override
    public List<Hotel> findAll() {
        return hotelDao.findAll();
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
