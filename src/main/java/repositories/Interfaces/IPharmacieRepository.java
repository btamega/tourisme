/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories.Interfaces;

import entities.Pharmacie;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IPharmacieRepository {
 
     public Pharmacie findById(Integer id);
    public Pharmacie findByName(String name);
    public List<Pharmacie> findAll();
    public Pharmacie save(Pharmacie pharmacie);
    public Pharmacie update(Pharmacie pharmacie);
    public void delete(Pharmacie pharmacie);
}
