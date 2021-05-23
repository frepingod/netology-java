package ru.netology.basics.homework5;

public class Author {
    public String name;
    public String surname;
    public int birthday;
    public String country;

    public Author(String name, String surname, int birthday, String country) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Автор{" +
                "Имя='" + name + '\'' +
                ", Фамилия='" + surname + '\'' +
                ", Год рождения=" + birthday +
                ", Страна='" + country + '\'' +
                '}';
    }
}