package ru.netology.multithreading.homework04.task2;

import java.util.Map;

public class GetThread extends Thread {

    protected static int counter = 0;
    private final Map<Long, Integer> map;
    private final long key = this.getId();

    public GetThread(Map<Long, Integer> map) {
        counter++;
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 1; i <= Main.NUMBER; i++) {
            map.get(key);
        }
        counter--;
    }
}