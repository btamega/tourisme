package dao.Interfaces;

import entities.Restaurant;

import java.util.List;

public interface IRestaurantDao {
    public List<Restaurant> findAll();
    public Restaurant findById(int id);
    public Restaurant findByName(String name);
    public Restaurant save(Restaurant restaurant);
    public Restaurant update(Restaurant restaurant);
    public void delete(Restaurant restaurant);
}
