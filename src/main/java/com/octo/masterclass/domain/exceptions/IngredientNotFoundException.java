package com.octo.masterclass.domain.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IngredientNotFoundException extends Exception {
    Logger logger = LogManager.getLogger(IngredientNotFoundException.class);
    public IngredientNotFoundException(String nom) {
        this.logger.warn("Ingredient(s) " + nom + " inexistant");
    }
}
