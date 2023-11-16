package com.octo.masterclass.restaurant;

import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    public Double calculerPrixFormule(Formule formule){
       return formule.composition.stream()
               .map(plat -> plat.getPrix())
               .reduce(Double::sum)
               .orElse(0.0);
    }
}
