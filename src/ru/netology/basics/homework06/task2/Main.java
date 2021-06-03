package ru.netology.basics.homework06.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = fillArray(10);

        System.out.println(Arrays.toString(products));

        myQuickSort(products, 0, products.length - 1);

        System.out.println(Arrays.toString(products));
    }

    private static Product[] fillArray(int length) {
        Product[] products = new Product[length];

        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(Integer.toString(i), (int) (0 + (Math.random() * 10)), Integer.toString(i));
        }

        return products;
    }

    private static void myQuickSort(Product[] products, int low, int high) {
        if (products.length == 0 || low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int opora = products[middle].getPrice();

        int i = low;
        int j = high;
        while (i <= j) {
            while (products[i].getPrice() < opora) {
                i++;
            }

            while (products[j].getPrice() > opora) {
                j--;
            }

            if (i <= j) {
                Product temp = products[i];
                products[i] = products[j];
                products[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            myQuickSort(products, low, j);
        }

        if (high > i) {
            myQuickSort(products, i, high);
        }
    }
}