package dao.Interfaces;

import entities.Hopital;

import java.util.List;

public interface IHopitalDao {
    public List<Hopital> findAll();
    public Hopital findById(int id);
    public Hopital findByName(String name);
    public Hopital save(Hopital hopital);
    public Hopital update(Hopital hopital);
    public void delete(Hopital hopital);
}
