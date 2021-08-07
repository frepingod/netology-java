package ru.netology.patterns.homework04.supplier;

import ru.netology.patterns.homework04.model.Product;

import java.util.List;

public interface Supplier {

    Product deliverProduct(Product product);

    List<Product> getProducts();
}