package ru.netology.multithreading.homework06.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<LandPlot> landPlots = Arrays.asList(
                new LandPlot(3, 2, 10000), //1666
                new LandPlot(4, 4, 20000), //1250
                new LandPlot(6, 6, 28800), //800
                new LandPlot(5, 7, 35000), //1000
                new LandPlot(1, 1, 9999)   //9999
        );

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите цену за 1 м2:");
            int pricePerSquareMeter = scanner.nextInt();

            //чистая функция
            Predicate<LandPlot> predicate = lp -> (lp.getPrice() / (lp.getLength() * lp.getWidth())) <= pricePerSquareMeter;

            landPlots.stream()
                    .filter(predicate)
                    .map(lp -> "Вам подходит: " + lp)
                    .forEach(System.out::println);
        }
    }
}