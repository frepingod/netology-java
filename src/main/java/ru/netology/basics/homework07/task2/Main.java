package ru.netology.basics.homework07.task2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static final int SIZE = 10;
    private static final int MAX_COUNT = 10;

    private static final int EMPTY = 0;
    private static final int SHIP = 1;
    private static final int DEAD = 2;
    private static final int MISS = 3;

    public static void main(String[] args) {
        int[][] warField = new int[SIZE][SIZE];
        placeTheShips(warField);
        printField(warField);

        playTheGame(warField);
    }

    private static void playTheGame(int[][] warField) {
        String input;

        int moveCount = 30;
        int shipCount = 10;

        while (true) {
            System.out.println("Ходов осталось: " + moveCount);
            System.out.println("Кораблей осталось: " + shipCount);
            System.out.println("Введите координаты корабля");
            input = scanner.nextLine();

            String[] splitInput = input.split(" ");
            int first = Integer.parseInt(splitInput[0]) - 1;
            int second = Integer.parseInt(splitInput[1]) - 1;

            switch (warField[first][second]) {
                case EMPTY:
                    System.out.println("Промах");
                    warField[first][second] = MISS;
                    moveCount--;
                    break;
                case SHIP:
                    System.out.println("Попал");
                    warField[first][second] = DEAD;
                    moveCount--;
                    shipCount--;
                    break;
                case DEAD:
                case MISS:
                    System.out.println("Вы уже сюда стреляли, выберите другие координаты");
                    break;
            }

            if (shipCount == 0) {
                System.out.println("Победа!");
                scanner.close();
                break;
            }

            if (moveCount == 0) {
                System.out.println("Увы, вы проиграли! Ходов больше не осталось");
                scanner.close();
                break;
            }
        }
    }

    private static void placeTheShips(int[][] warField) {
        Random random = new Random();

        for (int i = 0; i < MAX_COUNT; i++) {
            int shipPlace1 = random.nextInt(SIZE);
            int shipPlace2 = random.nextInt(SIZE);

            if (warField[shipPlace1][shipPlace2] == SHIP) {
                i--;
            }

            warField[shipPlace1][shipPlace2] = SHIP;
        }
    }

    private static void printField(int[][] warField) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(warField[i][j] + " ");
            }
            System.out.println();
        }
    }
}