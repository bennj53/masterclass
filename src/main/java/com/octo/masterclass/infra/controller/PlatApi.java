package com.octo.masterclass.infra.controller;

import java.util.List;

public record PlatApi(int id, String nom, double prix, List<IngredientApi> ingredients) {
}
