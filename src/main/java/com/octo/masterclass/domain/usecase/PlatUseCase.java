package com.octo.masterclass.domain.usecase;

import com.octo.masterclass.domain.entity.Plat;
import com.octo.masterclass.domain.repository.PlatRepository;
import org.springframework.stereotype.Component;

@Component
public class PlatUseCase {

    private final PlatRepository platRepository;

    public PlatUseCase(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    public Plat ajouter(Plat plat) throws Exception {
        return this.platRepository.ajouter(plat);
    }

    public void supprimer(Long id) throws Exception {
        this.platRepository.supprimer(id);
    }

    public Iterable<Plat> recupererTousLesPlats() {
        return this.platRepository.recupererTousLesPlats();
    }
}
