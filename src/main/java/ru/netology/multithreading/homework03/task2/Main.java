package ru.netology.multithreading.homework03.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    private static final int NUMBERS = 3;
    private static final int ARRAY_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        LongAdder longAdder = new LongAdder();

        List<int[]> shopsIncomes = generateShopsIncomes(NUMBERS, ARRAY_SIZE);

        for (int i = 1; i <= shopsIncomes.size(); i++) {
            System.out.println("Доход магазина " + i + ": " + Arrays.toString(shopsIncomes.get(i - 1)));
        }

        List<Thread> shopThreads = generateShopThreads(shopsIncomes, longAdder);

        for (Thread t : shopThreads) {
            t.join();
        }

        System.out.println("Выручка всех магазинов: " + longAdder.sum());
    }

    private static int[] generateArray(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * 7);
        }
        return array;
    }

    private static List<int[]> generateShopsIncomes(int number, int arraySize) {
        List<int[]> shopsIncomes = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            shopsIncomes.add(generateArray(arraySize));
        }
        return shopsIncomes;
    }

    private static List<Thread> generateShopThreads(List<int[]> shopsIncomes, LongAdder longAdder) {
        List<Thread> shopThreads = new ArrayList<>();
        for (int i = 0; i < shopsIncomes.size(); i++) {
            final int finalI = i;
            shopThreads.add(new Thread(null, () -> Arrays.stream(shopsIncomes.get(finalI)).forEach(longAdder::add), "Thread " + i));
            shopThreads.get(i).start();
        }
        return shopThreads;
    }
}