package ru.netology.basics.homework11.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> TASKS = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printListActions();

            String taskNum = SCANNER.nextLine();

            if ("end".equals(taskNum)) {
                System.out.println("Всего доброго!");
                SCANNER.close();
                break;
            }

            try {
                switch (Integer.parseInt(taskNum)) {
                    case 1:
                        System.out.println("Введите задачу для планирования:");
                        String task = SCANNER.nextLine();
                        TASKS.add(task);
                        System.out.println("Задача успешно добавлена!");
                        break;
                    case 2:
                        if (TASKS.isEmpty()) {
                            System.out.println("Список задач пуст!");
                            break;
                        }

                        printTasks(TASKS);
                        break;
                    case 3:
                        while (true) {
                            if (TASKS.isEmpty()) {
                                System.out.println("Список задач пуст!");
                                break;
                            }

                            printTasks(TASKS);

                            System.out.println("Введите номер задачи из списка (начиная с 1):");
                            System.out.println("'Finish' для выхода из режима удаления");

                            String str = SCANNER.nextLine();

                            if ("Finish".equals(str)) {
                                System.out.println("Удаление задач окончено!");
                                break;
                            }

                            try {
                                int index = Integer.parseInt(str) - 1;
                                TASKS.remove(index);
                                System.out.println("Задача успешно удалена!");
                            } catch (RuntimeException e) {
                                System.err.println("Некорректное значение, пожалуйста, повторите попытку!");
                            }
                        }
                        break;
                    default:
                        throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.err.println("Некорректное значение, пожалуйста, повторите попытку!");
            }
        }
    }

    private static void printListActions() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Вывести список задач");
        System.out.println("3. Удалить задачу");
        System.out.println("'end' для выхода из программы");
    }

    private static void printTasks(List<String> tasks) {
        System.out.println("Список задач:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.get(i));
        }
    }
}