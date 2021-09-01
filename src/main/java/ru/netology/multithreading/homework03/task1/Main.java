package ru.netology.multithreading.homework03.task1;

public class Main {

    public static volatile boolean isToggleSwitchOn = false;

    public static void main(String[] args) throws InterruptedException {
        Thread user = new UserThread();
        Thread toy = new ToyThread();

        user.start();
        toy.start();

        user.join();
        toy.interrupt();
    }
}