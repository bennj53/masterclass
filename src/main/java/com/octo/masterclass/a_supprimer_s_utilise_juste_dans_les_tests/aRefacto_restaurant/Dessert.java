package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant;

import java.util.List;

public class Dessert extends Plat{

    boolean seMangeFroid;

    public Dessert(String nom, Double prix, List<Ingredient> ingredients, boolean seMangeFroid) {
        super(nom, prix, ingredients);
        this.seMangeFroid = seMangeFroid;
    }

    public String mangerDessert() {
        return this.seMangeFroid ? "miam un dessert froid" : "miam un dessert chaud";
    }
}
