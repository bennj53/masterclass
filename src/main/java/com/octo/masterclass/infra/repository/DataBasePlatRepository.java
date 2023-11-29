package com.octo.masterclass.infra.repository;

import com.octo.masterclass.domain.entity.Plat;
import com.octo.masterclass.domain.repository.PlatRepository;
import org.springframework.stereotype.Service;

@Service
public class DataBasePlatRepository implements PlatRepository {

    private final DataBasePlatDAO dataBasePlatDAO;

    public DataBasePlatRepository(DataBasePlatDAO dataBasePlatDAO) {
        this.dataBasePlatDAO = dataBasePlatDAO;
    }

    @Override
    public Plat ajouter(Plat plat) throws Exception {
        return this.dataBasePlatDAO.save(plat);
    }

    @Override
    public void supprimer(Long id) throws Exception {
        this.dataBasePlatDAO.deleteById(id);
    }

    @Override
    public Iterable<Plat> recupererTousLesPlats() {
        return this.dataBasePlatDAO.findAll();
    }
}
