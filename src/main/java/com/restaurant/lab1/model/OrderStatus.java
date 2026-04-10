package com.restaurant.lab1.model;

public enum OrderStatus {
    CREADO("CREADO", "primary"),
    EN_PREPARACION("EN PREPARACIÓN", "warning"),
    LISTO("LISTO", "success"),
    ENTREGADO("ENTREGADO", "secondary");

    private final String displayName;
    private final String badgeColor;

    OrderStatus(String displayName, String badgeColor) {
        this.displayName = displayName;
        this.badgeColor = badgeColor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getBadgeColor() {
        return badgeColor;
    }

    public boolean isLast() {
        return this == ENTREGADO;
    }

    public OrderStatus next() {
        switch (this) {
            case CREADO:        return EN_PREPARACION;
            case EN_PREPARACION: return LISTO;
            case LISTO:         return ENTREGADO;
            default:            return ENTREGADO;
        }
    }
}
