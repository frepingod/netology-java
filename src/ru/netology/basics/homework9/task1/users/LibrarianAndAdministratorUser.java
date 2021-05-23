package ru.netology.basics.homework9.task1.users;

import ru.netology.basics.homework9.task1.Book;
import ru.netology.basics.homework9.task1.interfaces.Administrator;
import ru.netology.basics.homework9.task1.interfaces.Librarian;
import ru.netology.basics.homework9.task1.interfaces.Reader;
import ru.netology.basics.homework9.task1.interfaces.Supplier;

public class LibrarianAndAdministratorUser extends User implements Librarian, Administrator {
    public LibrarianAndAdministratorUser(String name) {
        super(name);
    }

    @Override
    public void findAndIssueBook(Reader reader, Book book) {
        System.out.println("Администратор " + name
                + " выдал читателю " + ((User) reader).getName()
                + " книгу " + book.getName());
    }

    @Override
    public void overdueNotification(Reader reader, Book book) {
        System.out.println("Читатель " + ((User) reader).getName()
                + "! Срочно верни книгу " + book.getName());
    }

    @Override
    public void orderBook(Supplier supplier, Book book) {
        System.out.println("Библиотекарь " + name
                + " заказал у поставщика " + ((User) supplier).getName()
                + " книгу " + book.getName());
    }
}