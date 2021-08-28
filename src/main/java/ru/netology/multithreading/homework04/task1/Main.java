package ru.netology.multithreading.homework04.task1;

public class Main {

    public static int numberOfAnsweredCalls = 0;
    public static final int NUMBER_OF_SPECIALIST = 3;

    public static void main(String[] args) throws InterruptedException {
        Atc atc = new Atc();

        new CallGeneratorThread(atc).start();

        for (int i = 0; i < NUMBER_OF_SPECIALIST; i++) {
            new SpecialistThread(atc).start();
        }
    }
}