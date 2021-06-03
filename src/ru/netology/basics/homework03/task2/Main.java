package ru.netology.basics.homework03.task2;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String biggestTask = "";
        String smallestTask = "";

        int totalTime = 0;
        int biggestTime = 0;
        int smallestTime = Integer.MAX_VALUE;

        while (true) {
            System.out.println("Введите название задачи:");
            String task = scanner.nextLine();

            System.out.println("Сколько дней потребуется на выполнение?");
            int days = scanner.nextInt();

            System.out.println("Сколько часов?");
            int hours = scanner.nextInt();

            System.out.println("Сколько минут?");
            int minutes = scanner.nextInt();

            int currentTimeTask = convertToSeconds(days, hours, minutes);
            totalTime += currentTimeTask;

            if (currentTimeTask > biggestTime) {
                biggestTime = currentTimeTask;
                biggestTask = task;
            }

            if (currentTimeTask < smallestTime) {
                smallestTime = currentTimeTask;
                smallestTask = task;
            }

            System.out.println("Для завершения работы программы введите \"end\" для продолжения нажмите \"enter\"");
            scanner.nextLine();
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                scanner.close();
                break;
            }
        }

        System.out.println("Всего потребуется: " +  totalTime + " секунд");
        System.out.println("Самая продолжительная задача \"" +  biggestTask + "\" займет: " +  biggestTime + " секунд");
        System.out.println("Самая короткая задача \"" +  smallestTask + "\" займет: " +  smallestTime + " секунд");
    }

    public static int convertToSeconds(int days, int hours, int minutes) {
        return (days * 86400) + (hours * 3600) + (minutes * 60);
    }
}