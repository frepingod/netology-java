package ru.netology.multithreading.homework01.task1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final ThreadGroup MAIN_GROUP = new ThreadGroup("main group");

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = createThreads(4);
        startThreads(threads);
        Thread.sleep(15000);
        interruptThreads();
    }

    private static List<Thread> createThreads(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new MyThread(MAIN_GROUP, "t" + i))
                .collect(Collectors.toList());
    }

    private static void startThreads(List<Thread> threads) {
        System.out.println("Создаю потоки...");
        threads.forEach(Thread::start);
    }

    private static void interruptThreads() {
        System.out.println("Завершаю все потоки.");
        MAIN_GROUP.interrupt();
    }
}