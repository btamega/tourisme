package services.Impl;

import dao.Impl.MongoDB.BibliothequeDaoImpl;
import dao.Interfaces.IBibliothqueDao;
import entities.Bibliotheque;

import java.util.List;
import lombok.NoArgsConstructor;
import services.Interfaces.IBibliothequeService;

@NoArgsConstructor
public class BibliothequeServiceImpl implements IBibliothequeService {
    private IBibliothqueDao bibliothqueDao = new BibliothequeDaoImpl();
    
    @Override
    public List<Bibliotheque> findAll() {
        return bibliothqueDao.findAll();
    }

    @Override
    public Bibliotheque findById(int id) {
        return null;
    }

    @Override
    public Bibliotheque findByName(String name) {
        return null;
    }

    @Override
    public Bibliotheque save(Bibliotheque bibliotheque) {
        return null;
    }

    @Override
    public Bibliotheque update(Bibliotheque bibliotheque) {
        return null;
    }

    @Override
    public void delete(Bibliotheque bibliotheque) {

    }
}
