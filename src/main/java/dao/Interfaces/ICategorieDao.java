package dao.Interfaces;

import entities.Categorie;

import java.util.List;

public interface ICategorieDao {
    public List<Categorie> findAll();
    public Categorie findById(int id);
    public Categorie findByName(String name);
    public Categorie save(Categorie categorie);
    public Categorie update(Categorie categorie);
    public void delete(Categorie categorie);
}
