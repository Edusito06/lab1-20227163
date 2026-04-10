package com.restaurant.lab1.model;

public class Dish {

    private Long id;
    private String name;
    private DishCategory category;
    private double price;
    private int prepTime;

    public Dish() {}

    public Dish(Long id, String name, DishCategory category, double price, int prepTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.prepTime = prepTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DishCategory getCategory() { return category; }
    public void setCategory(DishCategory category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getPrepTime() { return prepTime; }
    public void setPrepTime(int prepTime) { this.prepTime = prepTime; }
}
