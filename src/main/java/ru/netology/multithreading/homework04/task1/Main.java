package ru.netology.multithreading.homework04.task1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Atc atc = new Atc();

        new CallGeneratorThread(atc).start();

        Thread.sleep(3000);

        for (int i = 0; i < 3; i++) {
            new SpecialistThread(atc).start();
        }
    }
}