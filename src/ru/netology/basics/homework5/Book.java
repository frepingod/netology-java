package ru.netology.basics.homework5;

public class Book {
    public String name;
    public Author author;
    public String publication;
    public int year;
    public int pages;
    public boolean hardCover;

    public Book(String name, Author author, String publication, int year, int pages, boolean hardCover) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.year = year;
        this.pages = pages;
        this.hardCover = hardCover;
    }

    public static void comparePublications(Book book1, Book book2) {
        System.out.println("Издания " + ((book1.publication).equals(book2.publication) ? "одинаковые" : "разные"));
    }

    @Override
    public String toString() {
        return "Книга{" +
                "Название='" + name + '\'' +
                ", " + author +
                ", Издание='" + publication + '\'' +
                ", Год издания=" + year +
                ", Кол-во страниц=" + pages +
                ", Твердый переплет=" + hardCover +
                '}';
    }
}