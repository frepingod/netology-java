package ru.netology.patterns.homework04.shop;

import ru.netology.patterns.homework04.model.Product;
import ru.netology.patterns.homework04.ProductsCart;
import ru.netology.patterns.homework04.supplier.Supplier;

import java.util.List;

public interface Shop {

    ProductsCart getCart();

    List<Product> getProducts();

    boolean addToShoppingCart(Product product);

    boolean orderProduct(Supplier supplier, Product product);
}