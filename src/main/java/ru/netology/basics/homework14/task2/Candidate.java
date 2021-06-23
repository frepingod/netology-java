package ru.netology.basics.homework14.task2;

public class Candidate {

    private final String fullName;
    private final String sex;
    private final int age;
    private final int relevance;
    private final int rating;

    public Candidate(String fullName, String sex, int age, int relevance, int rating) {
        this.fullName = fullName;
        this.sex = sex;
        this.age = age;
        this.relevance = forRelevanceAndRating(relevance);
        this.rating = forRelevanceAndRating(rating);
    }

    public String getFullName() {
        return fullName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getRelevance() {
        return relevance;
    }

    public int getRating() {
        return rating;
    }

    private int forRelevanceAndRating(int number) {
        return (number < 0) ? 0 : Math.min(number, 5);
    }

    @Override
    public String toString() {
        return fullName + ", " + relevance + ", " + rating;
    }
}