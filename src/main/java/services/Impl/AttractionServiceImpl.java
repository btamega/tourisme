package services.Impl;

import dao.Impl.MongoDB.AttractionDaoImpl;
import dao.Interfaces.IAttractionDao;
import entities.Attraction;
import lombok.NoArgsConstructor;
import services.Interfaces.IAttractionService;

import java.util.List;

@NoArgsConstructor
public class AttractionServiceImpl implements IAttractionService {
    private IAttractionDao attractionDao = new AttractionDaoImpl();

    @Override
    public List<Attraction> findAll() {
        return attractionDao.findAll();
    }

    @Override
    public Attraction findById(int id) {
        return null;
    }

    @Override
    public Attraction findByName(String name) {
        return null;
    }

    @Override
    public Attraction save(Attraction attraction) {
        return null;
    }

    @Override
    public Attraction update(Attraction attraction) {
        return null;
    }

    @Override
    public void delete(Attraction attraction) {

    }
}
