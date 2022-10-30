package services.Impl;

import dao.Impl.MongoDB.RestaurantDaoImpl;
import dao.Interfaces.IRestaurantDao;
import entities.Restaurant;
import lombok.NoArgsConstructor;
import services.Interfaces.IRestaurantService;

import java.util.List;

@NoArgsConstructor
public class RestaurantServiceImpl implements IRestaurantService {
    private IRestaurantDao restaurantDao = new RestaurantDaoImpl();

    @Override
    public List<Restaurant> findAll() {
        return restaurantDao.findAll();
    }

    @Override
    public Restaurant findById(int id) {
        return null;
    }

    @Override
    public Restaurant findByName(String name) {
        return null;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return null;
    }

    @Override
    public void delete(Restaurant restaurant) {

    }
}
