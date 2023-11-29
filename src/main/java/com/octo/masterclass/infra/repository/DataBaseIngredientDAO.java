package com.octo.masterclass.infra.repository;

import com.octo.masterclass.domain.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataBaseIngredientDAO extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findByNom(String nom);
}
