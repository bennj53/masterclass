package com.octo.masterclass.fixtures;

import com.octo.masterclass.persistence.Ingredient;
import com.octo.masterclass.persistence.Plat;

import java.util.List;

public class PlatFixture {
    public static List<Plat> tousLesPlats(){
        Ingredient moules = new Ingredient("moule", true, 0);
        Ingredient riz = new Ingredient("riz", false, 0);
        Ingredient safran = new Ingredient("safran", false, 0);
        Ingredient pimentRouge = new Ingredient("piment rouge", false, 3);
        Ingredient vinaigre = new Ingredient("vinaigre", false, 0);

        List<Ingredient> ingredientsPaella = List.of(moules,riz,pimentRouge, safran);
        List<Ingredient> ingredientsRizVinaigre = List.of(riz,vinaigre);
        List<Ingredient> ingredientsMoulesPimentees = List.of(moules,pimentRouge);

        Plat paella = new Plat("paëlla", 15.50, ingredientsPaella);
        Plat rizVinaigre = new Plat("riz vinaigré", 5.0, ingredientsRizVinaigre);
        Plat moulesPimentees = new Plat("moules pimentées", 12.0, ingredientsMoulesPimentees);

        return List.of(
                paella,
                rizVinaigre,
                moulesPimentees
        );
    }
}
