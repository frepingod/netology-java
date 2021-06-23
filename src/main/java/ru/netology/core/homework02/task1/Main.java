package ru.netology.core.homework02.task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = new IntList().getIntList();
        List<Integer> resultList = new ArrayList<>();

        for (int i : intList) {
            if (i > 0 && (i % 2 == 0)) {
                resultList.add(i);
            }
        }

        Collections.sort(resultList);

        for (int i : resultList) {
            System.out.println(i);
        }
    }
}