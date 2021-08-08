package ru.netology.patterns.homework04.supplier;

import ru.netology.patterns.homework04.AllProducts;

public class BadSupplier extends AbstractSupplier {

    public BadSupplier() {
        products.add(AllProducts.WHISKAS);
        products.add(AllProducts.FELIX);
        products.add(AllProducts.KITEKAT);
    }

    @Override
    public void howDelivery() {
        System.out.println("Доставка только пешком :(");
    }
}