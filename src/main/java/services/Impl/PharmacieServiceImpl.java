package services.Impl;

import dao.Impl.MongoDB.PharmacieDaoImpl;
import dao.Interfaces.IPharmacieDao;
import entities.Pharmacie;
import lombok.NoArgsConstructor;
import services.Interfaces.IPharmacieService;

import java.util.List;

@NoArgsConstructor
public class PharmacieServiceImpl implements IPharmacieService {
    private IPharmacieDao pharmacieDao = new PharmacieDaoImpl();

    @Override
    public List<Pharmacie> findAll() {
        return pharmacieDao.findAll();
    }

    @Override
    public Pharmacie findById(int id) {
        return null;
    }

    @Override
    public Pharmacie findByName(String name) {
        return null;
    }

    @Override
    public Pharmacie save(Pharmacie pharmacie) {
        return null;
    }

    @Override
    public Pharmacie update(Pharmacie pharmacie) {
        return null;
    }

    @Override
    public void delete(Pharmacie pharmacie) {

    }
}
