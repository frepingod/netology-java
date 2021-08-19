package ru.netology.multithreading.homework01.task1;

public class MyThread extends Thread {

    public MyThread(ThreadGroup tg) {
        this(tg, "thread");
    }

    public MyThread(ThreadGroup tg, String name) {
        super(tg, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + ". Hello World");
            }
        } catch (InterruptedException e) {

        } finally {
            System.out.println(Thread.currentThread().getName() + ". завершен");
        }
    }
}