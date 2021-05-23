package ru.netology.basics.homework10.task2.event;

public abstract class Event {

    private String title;
    private int releaseYear;
    private int age;

    public Event(String title, int releaseYear, int age) {
        this.title = title;
        this.releaseYear = Math.max(releaseYear, 0);
        this.age = Math.max(age, 0);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", age=" + age +
                '}';
    }
}