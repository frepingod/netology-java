package ru.netology.basics.homework09.task1;

import ru.netology.basics.homework09.task1.interfaces.Administrator;
import ru.netology.basics.homework09.task1.interfaces.Librarian;
import ru.netology.basics.homework09.task1.interfaces.Reader;
import ru.netology.basics.homework09.task1.interfaces.Supplier;
import ru.netology.basics.homework09.task1.users.LibrarianAndAdministratorUser;
import ru.netology.basics.homework09.task1.users.ReaderAndSupplierUser;
import ru.netology.basics.homework09.task1.users.User;

public class Main {
    public static void main(String[] args) {
        User libAndAdmin = new LibrarianAndAdministratorUser("Петя");
        User readAndSupp = new ReaderAndSupplierUser("Вася");

        Book book1 = new Book("Властелин колец");
        Book book2 = new Book("Гарри Поттер");
        Book book3 = new Book("Скотт Пилигримм");

        ((Librarian) libAndAdmin).orderBook((Supplier) readAndSupp, book1);
        ((Administrator) libAndAdmin).findAndIssueBook((Reader) readAndSupp, book2);
        ((Administrator) libAndAdmin).overdueNotification((Reader) readAndSupp, book3);

        ((Reader) readAndSupp).getBook((Administrator) libAndAdmin, book1);
        ((Reader) readAndSupp).returnBook((Administrator) libAndAdmin, book2);
        ((Supplier) readAndSupp).bringBook((Librarian) libAndAdmin, book3);
    }
}