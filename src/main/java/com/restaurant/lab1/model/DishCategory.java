package com.restaurant.lab1.model;

public enum DishCategory {
    ENTRADA("Entrada"),
    PLATO_PRINCIPAL("Plato principal"),
    BEBIDA("Bebida");

    private final String displayName;

    DishCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
