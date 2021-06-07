package ru.netology.core.homework01.task2;

@FunctionalInterface
public interface OnTaskDoneListener {

    void onDone(String result);
}