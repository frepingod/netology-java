package ru.netology.basics.homework2.task1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int value1 = scanner.nextInt();

        System.out.println("Введите второе число:");
        int value2 = scanner.nextInt();

        System.out.println("Введите третье число:");
        int value3 = scanner.nextInt();

        int result = sum(value1, value2, value3);
        System.out.println("Сумма чисел = " + result);
    }

    private static int sum(int value1, int value2, int value3) {
        return value1 + value2 + value3;
    }
}