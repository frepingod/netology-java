package ru.netology.multithreading.homework01.task3;

import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Integer> {

    private int start;
    private int end;
    private int[] array;

    public ArraySumTask(int[] array) {
        this(0, array.length, array);
    }

    public ArraySumTask(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected Integer compute() {
        int diff = end - start;

        switch (diff) {
            case 0:
                return 0;
            case 1:
                return array[start];
            case 2:
                return array[start] + array[start + 1];
            default:
                return forkTasksAndGetResult();
        }
    }

    private Integer forkTasksAndGetResult() {
        int middle = (end - start) / 2 + start;

        ArraySumTask task1 = new ArraySumTask(start, middle, array);
        ArraySumTask task2 = new ArraySumTask(middle, end, array);

        invokeAll(task1, task2);

        return task1.join() + task2.join();
    }
}