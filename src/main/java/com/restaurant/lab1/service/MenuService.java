package com.restaurant.lab1.service;

import com.restaurant.lab1.model.Dish;
import com.restaurant.lab1.model.DishCategory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final List<Dish> menu = Arrays.asList(
            new Dish(1L, "Ensalada Cesar",   DishCategory.ENTRADA,        12.5, 10),
            new Dish(2L, "Sopa de Verduras", DishCategory.ENTRADA,         9.0,  8),
            new Dish(3L, "Ceviche",          DishCategory.ENTRADA,        15.0, 12),
            new Dish(4L, "Lomo Saltado",     DishCategory.PLATO_PRINCIPAL, 25.0, 20),
            new Dish(5L, "Arroz Chaufa",     DishCategory.PLATO_PRINCIPAL, 18.5, 15),
            new Dish(6L, "Pollo a la Brasa", DishCategory.PLATO_PRINCIPAL, 22.0, 25),
            new Dish(7L, "Limonada",         DishCategory.BEBIDA,           6.0,  3),
            new Dish(8L, "Agua Mineral",     DishCategory.BEBIDA,           3.5,  1)
    );

    public List<Dish> getAllDishes() {
        return menu;
    }

    public Optional<Dish> findById(Long id) {
        return menu.stream().filter(d -> d.getId().equals(id)).findFirst();
    }
}

//2. Inicializa git y sube la rama master (solo el proyecto base)
//
//
//cd "C:\Users\eduro\Desktop\lab1-20227163-edu"
//git init
//git add .
//git commit -m "init: crear proyecto Spring Boot"
//git branch -M master
//git remote add origin https://github.com/TU_USUARIO/lab1-20227163.git
//git push -u origin master
//3. Crea la rama feature/implementation y sube todo el código
//
//
//git checkout -b feature/implementation
//git push -u origin feature/implementation