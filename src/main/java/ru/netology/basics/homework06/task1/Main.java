package ru.netology.basics.homework06.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко"};
        int[] prices = new int[]{100, 200, 300};

        int arrLength = products.length; // OR prices.length

        int[] counts = new int[arrLength];
        int[] totalProductsSum = new int[arrLength];
        int totalSum = 0;

        System.out.println("Подходите, покупайте, в нашем магазине:");
        System.out.format("%5s%15s%15s\n", "№п/п", "Наименование", "Цена/за.ед");
        for (int i = 0; i < arrLength; i++) {
            System.out.format("%5s%15s%15s\n", (i + 1), products[i], prices[i]);
        }

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Выберите `товар количество` или введите `end`");
            input = scanner.nextLine();

            if ("end".equals(input)) {
                scanner.close();
                break;
            }

            String[] splitInput = input.split(" ");
            int productNumber = Integer.parseInt(splitInput[0]) - 1; // Для пользователя ввод продуктов начинается с 1!
            int productCount = Integer.parseInt(splitInput[1]);

            counts[productNumber] += productCount;
            int productsSum = (productCount * prices[productNumber]);
            totalProductsSum[productNumber] += productsSum;
            totalSum += productsSum;
        }

        if (totalSum == 0) {
            System.out.println("Ваша корзина пуста");
        } else {
            System.out.println("Ваша корзина:");
            System.out.format("%15s%15s%15s%20s\n", "Наименование", "Количество", "Цена/за.ед", "Общая стоимость");

            for (int i = 0; i < arrLength; i++) {
                if (counts[i] == 0) {
                    continue;
                }

                System.out.format("%15s%15s%15s%20s\n", products[i], counts[i], prices[i], totalProductsSum[i]);
            }

            System.out.println("ИТОГО СУММА ПОКУПОК: " + totalSum);
        }
    }
}