package ru.netology.multithreading.homework04.task1;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Atc {

    private final Queue<String> pullCalls = new PriorityBlockingQueue<>();

    public void addedCall(String call) {
        pullCalls.offer(call);
    }

    public String pollCall() {
        return pullCalls.poll();
    }
}