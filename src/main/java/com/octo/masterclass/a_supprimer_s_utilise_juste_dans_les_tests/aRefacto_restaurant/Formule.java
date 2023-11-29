package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant;

import java.util.List;

public class Formule {
    String nom;

    List<Plat> composition;

    public Formule(String nom, List<Plat> listePlat) {
        this.nom = nom;
        this.composition = listePlat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Plat> getComposition() {
        return composition;
    }

    public void setComposition(List<Plat> composition) {
        this.composition = composition;
    }
}
