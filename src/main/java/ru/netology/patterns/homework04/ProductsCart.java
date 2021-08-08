package ru.netology.patterns.homework04;

import ru.netology.patterns.homework04.model.Order;
import ru.netology.patterns.homework04.model.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ProductsCart {

    private final Orders orders = new Orders();

    private final Map<Product, Integer> products = new HashMap<>();

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public int size() {
        return products.size();
    }

    public void addedProduct(Product product) {
        products.put(product, 1);
    }

    public boolean increaseAmount(Product product) {
        products.put(product, products.get(product) + 1);
        return true;
    }

    public boolean reduceAmount(Product product) {
        int productCounter = products.get(product);
        if (productCounter > 0 && productCounter != 1) {
            products.put(product, productCounter - 1);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        return products.remove(product) != null;
    }

    public int totalSum() {
        return products.values().stream()
                .mapToInt(value -> value)
                .sum();
    }

    public void buy() {
        orders.addOrder(new Order(LocalDateTime.now(), totalSum()));
        products.clear();
    }
}