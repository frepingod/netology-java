package ru.netology.basics.homework09.task1.interfaces;

import ru.netology.basics.homework09.task1.Book;

public interface Administrator {
    void findAndIssueBook(Reader reader, Book book);

    void overdueNotification(Reader reader, Book book);
}