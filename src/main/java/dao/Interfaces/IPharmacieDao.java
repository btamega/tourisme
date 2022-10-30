package dao.Interfaces;

import entities.Pharmacie;

import java.util.List;

public interface IPharmacieDao {
    public List<Pharmacie> findAll();
    public Pharmacie findById(int id);
    public Pharmacie findByName(String name);
    public Pharmacie save(Pharmacie pharmacie);
    public Pharmacie update(Pharmacie pharmacie);
    public void delete(Pharmacie pharmacie);
}
