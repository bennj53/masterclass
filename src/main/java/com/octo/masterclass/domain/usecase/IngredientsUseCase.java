package com.octo.masterclass.domain.usecase;

import com.octo.masterclass.domain.entity.Ingredient;
import com.octo.masterclass.domain.repository.IngredientRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientsUseCase {

    private IngredientRepository ingredientRepository;

    public IngredientsUseCase(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> recupererUnIngredient(Ingredient ingredient) {
        return this.ingredientRepository.recupererDesIngredients(ingredient);
    }

    public List<Ingredient> recupererDesIngredients(List<Ingredient> ingredients) {
        List<Ingredient> ingredientsEnBDD = new ArrayList<>();
        ingredients.stream().map(this::recupererUnIngredient).forEach(ingredientsEnBDD::addAll);
        return ingredientsEnBDD;
    }

}
