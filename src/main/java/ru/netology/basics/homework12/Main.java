package ru.netology.basics.homework12;

import java.util.*;

public class Main {

    public static final int SPEED_TIME = 5;
    public static final int DOORS_CLOSE_AND_OPEN_TIME = 10;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Queue<Integer> ELEVATOR
            = new ArrayDeque<>();
            //= new LinkedList<>();

    public static void main(String[] args) {
        int previousFloor = -1;

        while (true) {
            System.out.println("Ожидаю ввода этажа 0-25: (для завершения введите 0)");
            int floor = SCANNER.nextInt();

            if (floor < 0 || floor > 25) {
                System.err.println("Такого этажа нет в доме, повторите попытку!");
                continue;
            }

            if (floor == previousFloor) {
                System.err.println("Вы уже на этом этаже, повторите попытку!");
                continue;
            }

            ELEVATOR.offer(floor);
            previousFloor = floor;

            if (floor == 0) {
                SCANNER.close();
                printQueueAndTime(ELEVATOR);
                break;
            }
        }
    }

    private static void printQueueAndTime(Queue<Integer> queue) {
        int totalSeconds = 0;
        int previousFloor = -1;
        int currentFloor;

        System.out.println("Лифт проследовал по следующим этажам:");

        while (!queue.isEmpty()) {
            currentFloor = queue.poll();
            System.out.print("Этаж " + currentFloor + (queue.isEmpty() ? "" : " -> "));
            totalSeconds += liftTime(previousFloor, currentFloor);
            previousFloor = currentFloor;
        }

        System.out.println("\nВремя, затраченное на поездку лифта в секундах: " + totalSeconds);
    }

    private static int liftTime(int previousFloor, int currentFloor) {
        return DOORS_CLOSE_AND_OPEN_TIME
                + (previousFloor != -1 ? (Math.abs(currentFloor - previousFloor) * SPEED_TIME) : 0);
    }
}