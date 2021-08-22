package ru.netology.multithreading.homework02.task2;

public class Main {

    public static void main(String[] args) {
        CarShowroom shop = new CarShowroom();

        for (int i = 0; i < 10; i++) {
            new Thread(null, shop::sellCar, "Покупатель" + i).start();
        }

        new Thread(null, shop::makeCar, "Поставщик автомобилей1").start();
    }
}