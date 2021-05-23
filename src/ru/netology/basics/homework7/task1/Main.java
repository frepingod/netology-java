package ru.netology.basics.homework7.task1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 8;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = fillMatrix();

        System.out.println("Изначальная матрица:");
        printMatrix(matrix);

        playTheGame(matrix);
    }

    private static void playTheGame(int[][] matrix) {
        System.out.println("Давайте покрутим матрицу!");
        String input;

        while (true) {
            System.out.println("Введите угол поворота: 90/180/270, 'end' для выхода");
            input = scanner.nextLine();

            if ("end".equals(input)) {
                System.out.println("Всего доброго!");
                scanner.close();
                break;
            }

            switch (Integer.parseInt(input)) {
                case 90:
                    rotate90(matrix);
                    printMatrix(matrix);
                    break;
                case 180:
                    rotate180(matrix);
                    printMatrix(matrix);
                    break;
                case 270:
                    rotate270(matrix);
                    printMatrix(matrix);
                    break;
                default:
                    System.out.println("Нет такого угла поворота!");
                    break;
            }
        }

        scanner.close();
    }

    private static int[][] fillMatrix() {
        int[][] matrix = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextInt(256);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void rotate90(int[][] matrix) {
        int[][] result = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = matrix[SIZE - j - 1][i];
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }

    private static void rotate180(int[][] matrix) {
        rotate90(matrix);
        rotate90(matrix);
    }

    private static void rotate270(int[][] matrix) {
        rotate180(matrix);
        rotate90(matrix);
    }
}