package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant;

import java.util.List;

public class Plat {

    private String nom;
    private Double prix;
    private List<Ingredient> ingredients;

    public Plat() {
    }

    public Plat(String nom, Double prix, List<Ingredient> ingredients) {
        this.nom = nom;
        this.prix = prix;
        this.ingredients = ingredients;
    }

    public Plat(Plat source) {
        this.nom = source.nom;
        this.prix = source.prix;
        this.ingredients = source.ingredients;
    }


    public void manger(){
        System.out.println("Miam");
    }

    public boolean isAllergene(){
        for (int i = 0; i < ingredients.size()-1; i++) {
            if(ingredients.get(i).isAllergene()){
                return true;
            }
        }
        return false;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
