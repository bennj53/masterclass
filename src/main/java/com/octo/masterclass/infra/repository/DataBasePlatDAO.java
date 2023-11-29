package com.octo.masterclass.infra.repository;

import com.octo.masterclass.domain.entity.Plat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataBasePlatDAO extends CrudRepository<Plat, Long> {
    @PersistenceContext
    ThreadLocal<EntityManager> entityManager = new ThreadLocal<>();

    //exemples requettes JPQL

    //par nom
    @Query("SELECT p FROM Plat p WHERE p.prix > :prixMin")
    List<Plat> findByPrixGreaterThanWithName(@Param("prixMin") Double prixMin);

    //par index
    @Query("SELECT p FROM Plat p WHERE p.prix > ?1")
    List<Plat> findByPrixGreaterThanWithIndex(Double prixMin);

    //exemple api Criteria
    default List<Plat> findByPrixGreaterThanUsingCriteria(Double prixMin) {
        CriteriaBuilder criteriaBuilder = entityManager.get().getCriteriaBuilder();
        CriteriaQuery<Plat> criteriaQuery = criteriaBuilder.createQuery(Plat.class);
        Root<Plat> platRoot = criteriaQuery.from(Plat.class);

        criteriaQuery.select(platRoot)
                .where(criteriaBuilder.greaterThan(platRoot.get("prix"), prixMin));

        return entityManager.get().createQuery(criteriaQuery).getResultList();
    }
}
