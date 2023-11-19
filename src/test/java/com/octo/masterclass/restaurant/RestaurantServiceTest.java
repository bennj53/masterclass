package com.octo.masterclass.restaurant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RestaurantServiceTest {

    @Test
    void calculerPrixFormule() {
        //Given
        RestaurantService restaurantService = new RestaurantService();
        Formule formule = new Formule("formule test", List.of(
                new Plat("ceviche", 20.50, List.of(
                        new Ingredient("citron", false, 0),
                        new Ingredient("poisson", true, 0)
                )),
                new Plat("tiramisu", 9.50, List.of(
                        new Ingredient("café", false, 0),
                        new Ingredient("mascarpone", true, 0)
                ))
                )
        );
        //When
        double prix = restaurantService.calculerPrixFormule(formule);
        //Then
        Assertions.assertEquals(30.0, prix);
    }

    @Test
    void calculerPrixPanier() {
        //Given
        double prixPanier;
        Ingredient moules = new Ingredient("moule", true, 0);
        Ingredient riz = new Ingredient("riz", false, 0);
        Ingredient safran = new Ingredient("safran", false, 0);
        Ingredient pimentRouge = new Ingredient("piment rouge", false, 3);
        Ingredient vinaigre = new Ingredient("vinaigre", false, 0);
        List<Ingredient> ingredientsPaella = List.of(moules,riz,pimentRouge, safran);
        List<Ingredient> ingredientsRizVinaigre = List.of(moules,riz,pimentRouge, safran);

        Plat paella = new Principal("paëlla", 15.50, ingredientsPaella, false);
        Plat rizVinaigre = new Entree("riz", 5.0, ingredientsRizVinaigre);

        Formule formule = new Formule("Entrée + Plat", List.of(rizVinaigre, paella));

        Panier panier = new Panier();
        panier.ajouterFormule(formule);
        panier.ajouterPlat(paella);

        RestaurantService restaurantService = new RestaurantService();

        //When
        prixPanier = restaurantService.calculerPrixPanier(panier);

        //Then
        Assertions.assertEquals(36, prixPanier);
    }
}