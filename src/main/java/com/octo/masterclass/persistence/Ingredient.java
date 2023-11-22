package com.octo.masterclass.persistence;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
public class Ingredient {

        @Id@GeneratedValue(strategy = GenerationType.AUTO)
        long id;
        String nom;
        boolean allergene;
        int kipik;

        public Ingredient() {
        }

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
