package ru.netology.patterns.homework03.task2;

public class Frog {

    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    private int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        int newPosition = position + steps;

        if (newPosition >= MIN_POSITION && newPosition <= MAX_POSITION) {
            position = newPosition;
            return true;
        }

        return false;
    }

    public char[] field() {
        char[] field = new char[11];

        for (int i = 0; i < field.length; i++) {
            field[i] = (i == position) ? 'F' : '-';
        }

        return field;
    }
}