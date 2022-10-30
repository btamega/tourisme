package services.Impl;

import dao.Impl.MongoDB.CategorieDaoImpl;
import dao.Interfaces.ICategorieDao;
import entities.Categorie;
import lombok.NoArgsConstructor;
import services.Interfaces.ICategorieService;

import java.util.List;

@NoArgsConstructor
public class CategorieServiceImpl implements ICategorieService {
    private ICategorieDao categorieDao = new CategorieDaoImpl();

    @Override
    public List<Categorie> findAll() {
        return categorieDao.findAll();
    }

    @Override
    public Categorie findById(int id) {
        return null;
    }

    @Override
    public Categorie findByName(String name) {
        return null;
    }

    @Override
    public Categorie save(Categorie categorie) {
        return null;
    }

    @Override
    public Categorie update(Categorie categorie) {
        return null;
    }

    @Override
    public void delete(Categorie categorie) {

    }
}
