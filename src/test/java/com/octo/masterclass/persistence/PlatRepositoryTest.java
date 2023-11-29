package com.octo.masterclass.persistence;

import com.octo.masterclass.domain.entity.Plat;
import com.octo.masterclass.fixtures.PlatFixture;
import com.octo.masterclass.infra.repository.DataBasePlatDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
class PlatRepositoryTest {
    @Autowired
    private DataBasePlatDAO platRepository;

    private final List<Plat> desPlats = PlatFixture.tousLesPlats();

    @Test
    public void testFindByPrixGreaterThanWithIndex() {
        // Given
        List<Plat>  platsAttendus = new ArrayList<>(List.of(desPlats.get(0), desPlats.get(2)));

        // When
        List<Plat> resultat = platRepository.findByPrixGreaterThanWithIndex(10.0);

        // Then
        Assertions.assertEquals(2, resultat.size());
    }

    @Test
    public void testFindByPrixGreaterThanWithName() {
        // Given
        List<Plat>  platsAttendus = new ArrayList<>(List.of(desPlats.get(0), desPlats.get(2)));

        // When
        List<Plat> resultat = platRepository.findByPrixGreaterThanWithName(10.0);

        // Then
        Assertions.assertEquals(2, resultat.size());
    }
}