package ru.netology.patterns.homework04;

import ru.netology.patterns.homework04.model.Order;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}