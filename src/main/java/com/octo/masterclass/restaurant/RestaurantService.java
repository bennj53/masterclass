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

    public double calculerPrixPanier(Panier panier) {
        double prixDesFormules = panier.formules.stream().mapToDouble(formule -> this.calculerPrixFormule(formule)).sum();
        double prixDesPlatsHorsFormule = panier.platsHorsFormule.stream().mapToDouble(plat -> plat.getPrix()).sum();
        return prixDesFormules + prixDesPlatsHorsFormule;
    }

    public Panier ajouterPlatAuPanier(Utilisateur utilisateur, Plat plat){
        utilisateur.getPanier().ajouterPlat(plat);
        return utilisateur.getPanier();
    }
}
