package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_api;

import com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant.Panier;
import com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant.Plat;
import com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant.RestaurantService;
import com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/panier")
public class PanierController {
    private RestaurantService restaurantService;

    public PanierController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<Panier> getPanier(@RequestParam Long id){
        return ResponseEntity.ok().body(new Panier());
    }

    @PostMapping
    public ResponseEntity<Panier> ajouterPlatAuPanier(@RequestBody Utilisateur utilisateur, @RequestBody Plat plat){
        return ResponseEntity.ok()
                .body(restaurantService.ajouterPlatAuPanier(utilisateur, plat));
    }
}
