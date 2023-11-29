package com.octo.masterclass.infra.controller;

import com.octo.masterclass.domain.entity.Ingredient;
import com.octo.masterclass.domain.entity.Plat;
import com.octo.masterclass.domain.exceptions.IngredientNotFoundException;
import com.octo.masterclass.domain.usecase.IngredientUseCase;
import com.octo.masterclass.domain.usecase.PlatUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plats")
public class PlatController {

    private final PlatUseCase platUseCase;

    private final IngredientUseCase ingredientUseCase;

    public PlatController(PlatUseCase platUseCase, IngredientUseCase ingredientUseCase) {
        this.platUseCase = platUseCase;
        this.ingredientUseCase = ingredientUseCase;
    }

    @GetMapping
    public ResponseEntity<Iterable<Plat>> getAllPlats() {
       return ResponseEntity.ok().body(this.platUseCase.recupererTousLesPlats());
    }

    @DeleteMapping(path = "/delete/{id}")
    public void supprimerPlat(@PathVariable Long id) throws Exception {
        this.platUseCase.supprimer(id);
    }

    @PostMapping
    public ResponseEntity<Plat> ajouterPlat(@RequestBody PlatApi platApiAAJouter) throws Exception {
        List<Ingredient> ingredientsDuPlat = platApiAAJouter.ingredients().stream()
                .map(ingredientApi -> new Ingredient(
                        ingredientApi.nom(),
                        ingredientApi.allergene(),
                        ingredientApi.kipik()))
                .toList();

        List<Ingredient> ingredientsDuPlatEnBDD = this.ingredientUseCase.recupererDesIngredients(ingredientsDuPlat);

        if(ingredientsDuPlatEnBDD.size() != ingredientsDuPlat.size()){
            List<String> nomsDesIngredientsDuPlatEnBDD = ingredientsDuPlatEnBDD.stream().map(Ingredient::getNom).toList();
            String nomDesIngredientsDuPlatInexistantEnBDD = ingredientsDuPlat.stream()
                    .map(Ingredient::getNom)
                    .filter(nomIngredientDuPlat -> !nomsDesIngredientsDuPlatEnBDD.contains(nomIngredientDuPlat))
                    .reduce((nom1, nom2) -> nom1 + ", " + nom2)
                    .orElseThrow();

            throw new IngredientNotFoundException(nomDesIngredientsDuPlatInexistantEnBDD);
        }

        Plat plat = new Plat(
                platApiAAJouter.nom(),
                platApiAAJouter.prix(),
                ingredientsDuPlatEnBDD
        );

       return ResponseEntity.ok()
               .body(this.platUseCase.ajouter(plat));
    }


}
