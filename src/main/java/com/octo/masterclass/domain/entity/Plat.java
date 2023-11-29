package com.octo.masterclass.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity()
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    Double prix;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "plats_ingredients",
            joinColumns = @JoinColumn(name = "plat_id"),
            inverseJoinColumns =   @JoinColumn(name = "ingredient_id")
    )
    List<Ingredient> ingredients;

    public Plat() {
    }

    public Plat(String nom, Double prix, List<Ingredient> ingredients) {
        this.nom = nom;
        this.prix = prix;
        this.ingredients = ingredients;
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
