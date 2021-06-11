package ru.netology.core.homework02.task1;

import java.util.Comparator;
import java.util.List;

public class StreamMain {

    public static void main(String[] args) {
        List<Integer> intList = new IntList().getIntList();

        intList.stream()
                .filter(x -> (x > 0) && (x % 2 == 0))
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}