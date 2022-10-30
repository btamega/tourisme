/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services.Interfaces;

import entities.Hotel;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IHotelService {
    public List<Hotel> findAll();
    public Hotel findById(int id);
    public Hotel findByName(String name);
    public Hotel save(Hotel hotel);
    public Hotel update(Hotel hotel);
    public void delete(Hotel hotel);
}
