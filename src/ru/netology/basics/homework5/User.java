package ru.netology.basics.homework5;

import java.util.List;

public class User {
    public static int totalOnline = 0;

    public String email;
    public String name;
    public String surname;
    public List<Book> books;

    public User(String email, String name, String surname, List<Book> books) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.books = books;
        totalOnline++;
    }

    @Override
    public String toString() {
        return "Пользователь: \n" +
                "Email='" + email + '\'' +
                ", Имя='" + name + '\'' +
                ", Фамилия='" + surname + "'\n" +
                "Книги=" + books + "\n";
    }
}