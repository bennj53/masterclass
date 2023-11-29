package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant;

import com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void quand_je_crée_un_panier_son_identifiant_est_incrémenté(){
        //When
        Panier panier0 = new Panier();
        Panier panier1 = new Panier();
        //Then
        Assertions.assertTrue(panier0.getIdentifiant() >= 0);
        Assertions.assertTrue(panier1.getIdentifiant() >= 1);
    }

}