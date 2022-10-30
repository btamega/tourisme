/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services.Interfaces;

import entities.Restaurant;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IRestaurantService {
    public List<Restaurant> findAll();
    public Restaurant findById(int id);
    public Restaurant findByName(String name);
    public Restaurant save(Restaurant restaurant);
    public Restaurant update(Restaurant restaurant);
    public void delete(Restaurant restaurant);
}
