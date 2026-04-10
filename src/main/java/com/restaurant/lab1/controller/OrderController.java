package com.restaurant.lab1.controller;

import com.restaurant.lab1.model.Order;
import com.restaurant.lab1.model.OrderForm;
import com.restaurant.lab1.service.MenuService;
import com.restaurant.lab1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String home() {
        return "redirect:/orders/new";
    }

    @GetMapping("/orders/new")
    public String showForm(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        model.addAttribute("dishes", menuService.getAllDishes());
        return "order-form";
    }

    @PostMapping("/orders/create")
    public String createOrder(@ModelAttribute OrderForm orderForm, Model model) {
        if (orderForm.getCustomerName() == null || orderForm.getCustomerName().isBlank()) {
            model.addAttribute("error", "El nombre del cliente es obligatorio.");
            model.addAttribute("dishes", menuService.getAllDishes());
            return "order-form";
        }
        if (orderForm.getDishIds() == null || orderForm.getDishIds().isEmpty()) {
            model.addAttribute("error", "Debe seleccionar al menos un plato.");
            model.addAttribute("dishes", menuService.getAllDishes());
            return "order-form";
        }

        Order order = orderService.createOrder(orderForm);
        return "redirect:/orders/" + order.getId() + "?msg=creado";
    }

    @GetMapping("/orders/{id}")
    public String showSummary(@PathVariable Long id,
                              @RequestParam(required = false) String msg,
                              Model model) {
        Order order = orderService.getOrderById(id);
        // si el id no existe redirige al historial
        if (order == null) {
            return "redirect:/orders/history";
        }
        model.addAttribute("order", order);
        model.addAttribute("msg", msg);
        return "order-summary";
    }

    @PostMapping("/orders/{id}/advance")
    public String advanceStatus(@PathVariable Long id) {
        orderService.advanceStatus(id);
        return "redirect:/orders/" + id + "?msg=avanzado";
    }

    @GetMapping("/orders/history")
    public String showHistory(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-history";
    }
}
