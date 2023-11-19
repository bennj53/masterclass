package com.octo.masterclass.restaurant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    @Test
    void quand_j_ajoute_un_plat_au_panier_alors_la_liste_de_plats_du_panier_contient_ce_plat(){
        //Given
        Ingredient moules = new Ingredient("moule", true, 0);
        Ingredient riz = new Ingredient("riz", false, 0);
        Ingredient safran = new Ingredient("safran", false, 0);
        Ingredient pimentRouge = new Ingredient("piment rouge", false, 3);
        Ingredient vinaigre = new Ingredient("vinaigre", false, 0);
        List<Ingredient> ingredientsPaella = List.of(moules,riz,pimentRouge, safran);

        Plat paella = new Principal("paëlla", 15.50, ingredientsPaella, false);

        List<Plat> platsDuPanierAttendus = List.of(paella);

        Panier panier = new Panier();

        //When
        panier.ajouterPlat(paella);

        //Then
        Assertions.assertIterableEquals(platsDuPanierAttendus, panier.platsHorsFormule);
    }

    @Test
    void quand_j_ajoute_une_formule_au_panier_alors_la_liste_de_formules_du_panier_contient_cette_formule(){
        //Given
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

        List<Formule> formulesDuPanierAttendus = List.of(formule);

        Panier panier = new Panier();

        //When
        panier.ajouterFormule(formule);

        //Then
        Assertions.assertIterableEquals(formulesDuPanierAttendus, panier.formules);
    }

}