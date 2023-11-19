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
}