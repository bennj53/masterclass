package com.octo.masterclass.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    List<Plat> platsHorsFormule;
    List<Formule> formules;

    public Panier() {
        this.platsHorsFormule = new ArrayList<>();
        this.formules = new ArrayList<>();
    }

    public List<Plat> getPlatsHorsFormule() {
        return platsHorsFormule;
    }

    public List<Formule> getFormules() {
        return formules;
    }

    public void ajouterFormule(Formule formule) {
        this.formules.add(formule);
    }

    public void ajouterPlat(Plat plat) {
        this.platsHorsFormule.add(plat);
    }

    public void supprimerFormule(Formule formule) {
        this.formules.add(formule);
    }

    public void supprimerPlat(Plat plat) {
        this.platsHorsFormule.add(plat);
    }
}
