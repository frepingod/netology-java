package ru.netology.basics.homework09.task1.users;

import ru.netology.basics.homework09.task1.Book;
import ru.netology.basics.homework09.task1.interfaces.Administrator;
import ru.netology.basics.homework09.task1.interfaces.Librarian;
import ru.netology.basics.homework09.task1.interfaces.Reader;
import ru.netology.basics.homework09.task1.interfaces.Supplier;

public class ReaderAndSupplierUser extends User implements Reader, Supplier {
    public ReaderAndSupplierUser(String name) {
        super(name);
    }

    @Override
    public void getBook(Administrator administrator, Book book) {
        System.out.println("Читатель " + name
                + " получил от администратора " + ((User) administrator).getName()
                + " книгу " + book.getName());
    }

    @Override
    public void returnBook(Administrator administrator, Book book) {
        System.out.println("Читатель " + name
                + " вернул администратору " + ((User) administrator).getName()
                + " книгу " + book.getName());
    }

    @Override
    public void bringBook(Librarian librarian, Book book) {
        System.out.println("Поставщик " + name
                + " принес библиотекарю " + ((User) librarian).getName()
                + " книгу " + book.getName());
    }
}