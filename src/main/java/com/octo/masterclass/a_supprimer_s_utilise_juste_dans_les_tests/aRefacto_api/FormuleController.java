package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_api;

import com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/formules")
public class FormuleController {

    Plat rizAuLait = new Dessert("riz au lait", 5.0, List.of(
            new Ingredient("riz", false, 0),
            new Ingredient("lait", true, 0)
    ),true);
    Plat couscous = new Principal("couscous", 10.0, List.of(
            new Ingredient("semoule", false, 0),
            new Ingredient("merguez", false, 2)
    ),false);

    Formule bestOf = new Formule("best Of", List.of(rizAuLait, couscous));
    Formule maxibestOf = new Formule("maxi best Of", List.of(rizAuLait, couscous));
    Formule petiteFaim = new Formule("petite Faim", List.of(rizAuLait, couscous));

    List<Formule> carte = List.of(bestOf, maxibestOf, petiteFaim);

    private RestaurantService service;

    public FormuleController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping
    List<Formule> getFormules(){
        return carte;
    }

    @GetMapping("/prix")
    Double getPrixBestOf(){
        return service.calculerPrixFormule(bestOf);
    }
}
