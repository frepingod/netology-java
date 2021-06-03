package ru.netology.basics.homework03.task1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год в формате \"yyyy\":");
        int year = Integer.parseInt(scanner.nextLine());
        scanner.close();

        int leapYear = isLeapYear(year) ? 366 : 365;
        System.out.println("Количество дней в году: " + leapYear);
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}