package ru.netology.patterns.homework01.task2;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("Введите размер списка: ");
        int size = SCANNER.nextInt();

        System.out.print("Введите верхнюю границу для значений: ");
        int treshold = SCANNER.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> list = createList(size, treshold);

        System.out.println("Вот случайный список: " + list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");

        System.out.print("Введите порог для фильтра: ");
        int f = SCANNER.nextInt();

        logger.log("Запускаем фильтрацию");

        Filter filter = new Filter(f);
        List<Integer> filteredList = filter.filterOut(list);

        logger.log("Выводим результат на экран");

        System.out.println("Отфильтрованный список: " + filteredList);

        logger.log("Завершаем программу");
    }

    private static List<Integer> createList(int size, int treshold) {
        Random random = new Random();
        return IntStream.range(0, size)
                .mapToObj(i -> random.nextInt(treshold))
                .collect(Collectors.toList());
    }
}