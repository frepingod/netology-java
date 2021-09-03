package ru.netology.multithreading.homework03.task1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ToggleSwitch toggleSwitch = new ToggleSwitch(false);

        Thread user = new UserThread("Поток-пользователь", toggleSwitch);
        Thread toy = new ToyThread("Поток-игрушка", toggleSwitch);

        user.start();
        toy.start();

        user.join();
        toy.interrupt();
    }
}