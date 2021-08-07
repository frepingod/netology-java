package ru.netology.patterns.homework04;

import ru.netology.patterns.homework04.shop.CatFoodShop;
import ru.netology.patterns.homework04.shop.Shop;
import ru.netology.patterns.homework04.supplier.BadSupplier;
import ru.netology.patterns.homework04.supplier.GoodSupplier;
import ru.netology.patterns.homework04.supplier.Supplier;
import ru.netology.patterns.homework04.supplier.SupplierImpl;

public class Main {

    public static void main(String[] args) {
        SupplierImpl bad = new BadSupplier();
        Supplier good = new GoodSupplier();
        Shop shop = new CatFoodShop();
    }
}