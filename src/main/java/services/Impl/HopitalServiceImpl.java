package services.Impl;

import dao.Impl.MongoDB.HopitalDaoImpl;
import dao.Interfaces.IHopitalDao;
import entities.Hopital;
import lombok.NoArgsConstructor;
import services.Interfaces.IHopitalService;

import java.util.List;

@NoArgsConstructor
public class HopitalServiceImpl implements IHopitalService {
    private IHopitalDao hopitalDao = new HopitalDaoImpl();

    @Override
    public List<Hopital> findAll() {
        return hopitalDao.findAll();
    }

    @Override
    public Hopital findById(int id) {
        return null;
    }

    @Override
    public Hopital findByName(String name) {
        return null;
    }

    @Override
    public Hopital save(Hopital hopital) {
        return null;
    }

    @Override
    public Hopital update(Hopital hopital) {
        return null;
    }

    @Override
    public void delete(Hopital hopital) {

    }
}
