package ru.netology.multithreading.homework04.task2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static final int THREADS = 1;
    public static final int NUMBER = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        Map<Long, Integer> wrapper = Collections.synchronizedMap(new HashMap<>());
        Map<Long, Integer> concurrent = new ConcurrentHashMap<>();

        System.out.println("Put time wrapper " + testPut(wrapper) + "ms.");
        System.out.println("Put time concurrent " + testPut(concurrent) + "ms.");

        System.out.println("Get time wrapper " + testGet(wrapper) + "ms.");
        System.out.println("Get time concurrent " + testGet(concurrent) + "ms.");
    }

    public static long testPut(Map<Long, Integer> map) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREADS; i++) {
            new PutThread(map).start();
        }
        while (PutThread.counter > 0) {
            Thread.sleep(1);
        }
        return System.currentTimeMillis() - start;
    }

    public static long testGet(Map<Long, Integer> map) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREADS; i++) {
            new GetThread(map).start();
        }
        while (GetThread.counter > 0) {
            Thread.sleep(1);
        }
        return System.currentTimeMillis() - start;
    }
}