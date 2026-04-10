package com.restaurant.lab1.model;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {

    private String customerName;
    private String serviceType;
    private List<Long> dishIds = new ArrayList<>();

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public List<Long> getDishIds() { return dishIds; }
    public void setDishIds(List<Long> dishIds) { this.dishIds = dishIds; }
}
