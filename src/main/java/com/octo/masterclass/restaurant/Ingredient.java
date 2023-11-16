package com.octo.masterclass.restaurant;

public final class Ingredient {

    String nom;
    boolean allergene;
    int kipik;

    public Ingredient(String nom, boolean allergene, int kipik) {
        this.nom = nom;
        this.allergene = allergene;
        this.kipik = kipik;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isAllergene() {
        return allergene;
    }

    public void setAllergene(boolean allergene) {
        this.allergene = allergene;
    }

    public int getKipik() {
        return kipik;
    }

    public void setKipik(int kipik) {
        this.kipik = kipik;
    }
}
