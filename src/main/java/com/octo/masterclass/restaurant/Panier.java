package com.octo.masterclass.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private static Long identifiantGenerateur = 0L;
    List<Plat> platsHorsFormule;
    List<Formule> formules;
    Long identifiant;

    public Panier() {
        this.platsHorsFormule = new ArrayList<>();
        this.formules = new ArrayList<>();
        this.identifiant = identifiantGenerateur++;
    }

    public Panier(List<Plat> platsHorsFormule, List<Formule> formules, Long identifiant) {
        this.platsHorsFormule = platsHorsFormule;
        this.formules = formules;
        this.identifiant = identifiant;
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

    public Long getIdentifiant() {
        return identifiant;
    }
}
