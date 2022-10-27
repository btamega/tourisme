/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories.Interfaces;

import entities.Hopital;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IHopitalRepository {
    
     public Hopital findById(Integer id);
    public Hopital findByName(String name);
    public List<Hopital> findAll();
    public Hopital save(Hopital hopital);
    public Hopital update(Hopital hopital);
    public void delete(Hopital hopital);
    
}
