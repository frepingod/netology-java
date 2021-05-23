package ru.netology.basics.homework4.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        String result = "";

        while (true) {
            System.out.println("Введите ASCII код 'Oct' ('end' для вывода результата):");
            input = scanner.nextLine();

            if ("end".equals(input)) {
                scanner.close();
                break;
            }

            int convertToDecimalNotation = Integer.parseInt(input, 8);
            char c = (char) convertToDecimalNotation;
            result += c;

            System.out.println("Соответствующий символ: " + c + "\n");
        }

        System.out.println(result);
    }
}