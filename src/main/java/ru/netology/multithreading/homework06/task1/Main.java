package ru.netology.multithreading.homework06.task1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        /**
         * Что в этой программе от функционального программирования:
         *
         * 1. Поле sourceText - final и immutable;
         * 2. function - детерменирован (результат работы зависит только от входных параметров и ни от чего больше);
         * 3. Использование функционального интерфейса и лямбда-выражений для написания детерменированной функции;
         * 4. У function нет побочного эффекта, можно удалить печать в консоль, и побочного эффекта не будет вовсе;
         * 5. Использовапние stream для реализации монад.
         */

        final String sourceText = "Я в меовс иинанзоп окьлотсан яслинлопсиерп " +
                "отч я как отдуб ыб ежу отс воноиллирт водраиллим тел юавижорп ан ханоиллирт " +
                "и ханоиллирт хикат еж теналп как атэ ялмеЗ енм тотэ рим онтюлосба нетяноп";

        Function<String, String> function = str -> Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().append(" "))
                .collect(Collectors.joining());

        System.out.println(function.apply(sourceText));
    }
}