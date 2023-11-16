package com.octo.masterclass.restaurant;

import java.util.List;

public class Principal extends Plat{

    boolean seMangeFroid;

    public Principal(String nom, Double prix, List<Ingredient> ingredients, boolean seMangeFroid) {
        super(nom, prix, ingredients);
        this.seMangeFroid = seMangeFroid;
    }

    @Override
    public void manger() {
        if (this.seMangeFroid) System.out.println("miam un plat froid");
        else System.out.println("miam un plat chaud");
    }
}
