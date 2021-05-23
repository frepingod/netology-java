package ru.netology.basics.homework8.task1;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Player player = new Player();
        int slot;

        printPlayerWeapons(player);
        System.out.println("Введите номер (начиная с 0), чтобы выстрелить, -1 чтобы выйти");

        while (true) {
            slot = scanner.nextInt();

            if (slot == -1) {
                System.out.println("Game over!");
                scanner.close();
                break;
            }

            player.shotWithWeapon(slot);
        }
    }

    private static void printPlayerWeapons(Player player) {
        System.out.println("У игрока " + player.getSlotsCount() + " слотов с оружием");
        System.out.println("Список оружия игрока: ");
        for (int i = 0; i < player.getSlotsCount(); i++) {
            System.out.println("\t" + i + ". " + player.weaponNames()[i]);
        }
    }
}