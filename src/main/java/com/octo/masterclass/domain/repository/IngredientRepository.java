package com.octo.masterclass.domain.repository;

import com.octo.masterclass.domain.entity.Ingredient;

import java.util.List;

public interface IngredientRepository {

    List<Ingredient> recupererDesIngredients(Ingredient ingredient);

}
