/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services.Interfaces;

import entities.Attraction;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IAttractionService {
    public List<Attraction> findAll();
    public Attraction findById(int id);
    public Attraction findByName(String name);
    public Attraction save(Attraction attraction);
    public Attraction update(Attraction attraction);
    public void delete(Attraction attraction);
}
