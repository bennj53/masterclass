package com.octo.masterclass.a_supprimer_s_utilise_juste_dans_les_tests.aRefacto_restaurant;

public class Utilisateur {
    String nom;
    String prenom;
    Panier panier;

    public Utilisateur(String nom, String prenom, Panier panier) {
        this.nom = nom;
        this.prenom = prenom;
        this.panier = panier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
