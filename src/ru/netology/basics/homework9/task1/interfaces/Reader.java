package ru.netology.basics.homework9.task1.interfaces;

import ru.netology.basics.homework9.task1.Book;

public interface Reader {
    void getBook(Administrator administrator, Book book);

    void returnBook(Administrator administrator, Book book);
}