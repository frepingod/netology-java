package ru.netology.multithreading.homework01.task3;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final int ARRAY_SIZE = 1_000_000_000;

    public static void main(String[] args) {
        int[] array = createArray(ARRAY_SIZE);

        long beforeSingle = System.currentTimeMillis();
        int single = singleThreadedCounting(array);
        long afterSingle = System.currentTimeMillis();
        System.out.println("Результат однопоточного подсчета суммы элементов массива: " + single);
        System.out.println("Затрачено времени, мс: " + (afterSingle - beforeSingle));

        long beforeMulti = System.currentTimeMillis();
        int multi = multiThreadedCounting(array);
        long afterMulti = System.currentTimeMillis();
        System.out.println("Результат многопоточного подсчета суммы элементов массива: " + multi);
        System.out.println("Затрачено времени, мс: " + (afterMulti - beforeMulti));
    }

    private static int[] createArray(int size) {
        int[] array = new int[size];
        Arrays.fill(array, 2);
        return array;
    }

    private static int singleThreadedCounting(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    private static int multiThreadedCounting(int[] array) {
        ArraySumTask counter = new ArraySumTask(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        return forkJoinPool.invoke(counter);
    }
}