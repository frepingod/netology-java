package ru.netology.basics.homework4.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Операции над double/float. Введите номер операции.");
        System.out.println("1. Сравнить");
        System.out.println("2. Округлить");
        System.out.println("3. Отбросить дробную часть");

        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        double value1;
        double value2;

        switch (operation) {
            case 1:
                System.out.println("Введите первое число:");
                value1 = scanner.nextDouble();

                System.out.println("Введите второе число:");
                value2 = scanner.nextDouble();

                compare(value1, value2);
                break;
            case 2:
                System.out.println("Введите число:");
                value1 = scanner.nextDouble();

                roundOff(value1);
                break;
            case 3:
                System.out.println("Введите число:");
                value1 = scanner.nextDouble();

                discardFractionalPart(value1);
                break;
            default:
                System.out.println("Нет такой операции");
        }

        scanner.close();
    }

    private static void compare(double value1, double value2) {
        double max = Math.max(value1, value2);
        double min = Math.min(value1, value2);
        double eps = 0.000001;

        if (value1 == value2 || max - min < eps) {
            System.out.println("Числа равны");
        } else {
            System.out.println(max + " больше чем " + min + " на " + (max - min));
        }
    }

    private static void roundOff(double value) {
        System.out.println("Число " + value + " в округленном виде: " + Math.round(value));
    }

    private static void discardFractionalPart(double value) {
        System.out.println("Число " + value + " без дробной части: " + (long) value);
    }
}