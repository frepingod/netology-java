package ru.netology.basics.homework9.task1.interfaces;

import ru.netology.basics.homework9.task1.Book;

public interface Librarian {
    void orderBook(Supplier supplier, Book book);
}