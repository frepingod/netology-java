package ru.netology.basics.homework5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Author joanneRowling = new Author("Джоан", "Роулинг", 1965, "Великобритания");
        Book potterOld1 = new Book("Гарри Поттер 1", joanneRowling, "Росмэн", 2002, 399, true);
        Book potterNew1 = new Book("Гарри Поттер 1", joanneRowling, "Махаон", 2017, 432, true);
        Book potterOld3 = new Book("Гарри Поттер 3", joanneRowling, "Росмэн", 2002, 572, true);

        Book.comparePublications(potterOld1, potterNew1);
        Book.comparePublications(potterOld1, potterOld3);

        Book javaBook = new Book("Java Руководство для начинающих 7-е издание",
                new Author("Герберт", "Шилдт", 1951, "США"),
                "Диалектика", 2019, 809, true);

        List<Book> someBooks1 = new ArrayList<>();
        someBooks1.add(potterNew1);
        someBooks1.add(potterOld3);

        List<Book> someBooks2 = new ArrayList<>();
        someBooks2.add(javaBook);
        someBooks2.add(potterOld1);

        User user1 = new User("admin@admin.com", "Петя", "Петров", someBooks1);
        User user2 = new User("user@user.com", "Иван", "Иванов", someBooks1);
        System.out.println("Количество юзеров: " + User.totalOnline);

        User user3 = new User("java_dev@java_dev.ru", "Квентин", "Тарантино", someBooks2);
        System.out.println("Количество юзеров: " + User.totalOnline);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}