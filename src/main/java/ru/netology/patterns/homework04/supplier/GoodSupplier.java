package ru.netology.patterns.homework04.supplier;

import ru.netology.patterns.homework04.AllProducts;

public class GoodSupplier extends AbstractSupplier {

    public GoodSupplier() {
        products.add(AllProducts.ROYAL_CANIN);
        products.add(AllProducts.FIRST_CHOICE);
        products.add(AllProducts.GO);
    }

    @Override
    public void howDelivery() {
        System.out.println("Для доставки используется скромная служебная машина Aston Martin");
    }
}