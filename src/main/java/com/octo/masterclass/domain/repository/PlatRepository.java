package com.octo.masterclass.domain.repository;

import com.octo.masterclass.domain.entity.Plat;

public interface PlatRepository {

    Plat ajouter(Plat plat) throws Exception;

    void supprimer(Long id) throws Exception;

    Iterable<Plat> recupererTousLesPlats();
}
