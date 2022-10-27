/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories.Interfaces;

import entities.Bibliotheque;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IBibliothequeRepository {
    
    public Bibliotheque findById(Integer id);
    public Bibliotheque findByName(String name);
    public List<Bibliotheque> findAll();
    public Bibliotheque save(Bibliotheque bibliotheque);
    public Bibliotheque update(Bibliotheque bibliotheque);
    public void delete(Bibliotheque bibliotheque);
    
}
