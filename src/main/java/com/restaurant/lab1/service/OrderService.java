package com.restaurant.lab1.service;

import com.restaurant.lab1.model.Dish;
import com.restaurant.lab1.model.Order;
import com.restaurant.lab1.model.OrderForm;
import com.restaurant.lab1.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Autowired
    private MenuService menuService;

    public Order createOrder(OrderForm form) {
        List<Dish> selectedDishes = new ArrayList<>();
        for (Long dishId : form.getDishIds()) {
            menuService.findById(dishId).ifPresent(selectedDishes::add);
        }

        int totalTime = selectedDishes.stream().mapToInt(Dish::getPrepTime).sum();
        double totalPrice = selectedDishes.stream().mapToDouble(Dish::getPrice).sum();

        Order order = new Order();
        order.setId(idCounter.getAndIncrement());
        order.setCustomerName(form.getCustomerName().trim());
        order.setServiceType(form.getServiceType());
        order.setDishes(selectedDishes);
        order.setStatus(OrderStatus.CREADO);
        order.setTotalTime(totalTime);
        order.setTotalPrice(totalPrice);

        orders.add(order);
        return order;
    }

    public Order getOrderById(Long id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void advanceStatus(Long id) {
        Order order = getOrderById(id);
        if (order != null && !order.getStatus().isLast()) {
            order.setStatus(order.getStatus().next());
        }
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
