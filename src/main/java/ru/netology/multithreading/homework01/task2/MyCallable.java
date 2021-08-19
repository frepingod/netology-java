package ru.netology.multithreading.homework01.task2;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() {
        int count = 0;

        try {
            while (random() != 3) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ". Hello World");
                count++;
            }
        } catch (InterruptedException e) {

        } finally {
            System.out.println(Thread.currentThread().getName() + ". завершен");
        }

        return Thread.currentThread().getName() + " - " + count;
    }

    private int random() {
        return (int) (Math.random() * 7);
    }
}