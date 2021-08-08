package ru.netology.patterns.homework04.shop;

import ru.netology.patterns.homework04.AllProducts;
import ru.netology.patterns.homework04.ProductsCart;
import ru.netology.patterns.homework04.model.Product;
import ru.netology.patterns.homework04.supplier.Supplier;

import java.util.ArrayList;
import java.util.List;

public class CatFoodShop implements Shop {

    private final ProductsCart cart = new ProductsCart();

    private final List<Product> products;

    public CatFoodShop() {
        products = new ArrayList<>();
        products.add(AllProducts.ROYAL_CANIN);
        products.add(AllProducts.FIRST_CHOICE);
        products.add(AllProducts.GO);
    }

    @Override
    public ProductsCart getCart() {
        return cart;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean addToShoppingCart(Product product) {
        for (Product p : products) {
            if (p.equals(product)) {
                cart.addedProduct(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean orderProduct(Supplier supplier, Product product) {
        Product deliverProduct = supplier.deliverProduct(product);
        if (deliverProduct != null) {
            products.add(deliverProduct);
            return true;
        }
        return false;
    }
}