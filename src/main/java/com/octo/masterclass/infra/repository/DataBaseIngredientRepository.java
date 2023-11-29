package com.octo.masterclass.infra.repository;

import com.octo.masterclass.domain.entity.Ingredient;
import com.octo.masterclass.domain.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DataBaseIngredientRepository implements IngredientRepository {

    private DataBaseIngredientDAO dataBaseIngredientDAO;

    public DataBaseIngredientRepository(DataBaseIngredientDAO dataBaseIngredientDAO) {
        this.dataBaseIngredientDAO = dataBaseIngredientDAO;
    }

    @Override
    public List<Ingredient> recupererDesIngredients(Ingredient ingredient) {
        List<Ingredient> ingredients = this.dataBaseIngredientDAO.findByNom(ingredient.getNom());
        if(ingredients == null){
            return Collections.emptyList();
        }

        return ingredients;
    }
}
