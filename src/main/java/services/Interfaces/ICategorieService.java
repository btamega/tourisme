/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services.Interfaces;

import entities.Categorie;
import java.util.List;

/**
 *
 * @author dell
 */
public interface ICategorieService {
    public List<Categorie> findAll();
    public Categorie findById(int id);
    public Categorie findByName(String name);
    public Categorie save(Categorie categorie);
    public Categorie update(Categorie categorie);
    public void delete(Categorie categorie);
}
