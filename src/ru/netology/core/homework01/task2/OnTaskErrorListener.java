package ru.netology.core.homework01.task2;

@FunctionalInterface
public interface OnTaskErrorListener {

    void onError(String result);
}