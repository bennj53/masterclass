package com.octo.masterclass.infra.repository;

import com.octo.masterclass.domain.entity.Plat;
import com.octo.masterclass.domain.repository.PlatRepository;
import org.springframework.stereotype.Service;

@Service
public class DataBasePlatRepository implements PlatRepository {

    private final DataBasePlatDAO platRepository;

    public DataBasePlatRepository(DataBasePlatDAO platRepository) {
        this.platRepository = platRepository;
    }

    @Override
    public Plat ajouter(Plat plat) throws Exception {
        return this.platRepository.save(plat);
    }

    @Override
    public void supprimer(Long id) throws Exception {
        this.platRepository.deleteById(id);
    }

    @Override
    public Iterable<Plat> recupererTousLesPlats() {
        return this.platRepository.findAll();
    }
}
