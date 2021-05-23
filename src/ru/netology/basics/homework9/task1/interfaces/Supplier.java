package ru.netology.basics.homework9.task1.interfaces;

import ru.netology.basics.homework9.task1.Book;

public interface Supplier {
    void bringBook(Librarian librarian, Book book);
}