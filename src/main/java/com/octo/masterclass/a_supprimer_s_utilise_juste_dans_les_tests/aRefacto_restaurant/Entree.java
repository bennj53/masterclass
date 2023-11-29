package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant;

import java.util.List;

public class Entree extends Plat{
    public Entree() {
    }

    public Entree(String nom, Double prix, List<Ingredient> ingredients) {
        super(nom, prix, ingredients);
    }

    public Entree(Plat source) {
        super(source);
    }
}
