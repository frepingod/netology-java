package ru.netology.basics.homework10.task2;

import ru.netology.basics.homework10.task2.event.Event;
import ru.netology.basics.homework10.task2.event.Movie;
import ru.netology.basics.homework10.task2.event.Theatre;

public class Main {

    public static void main(String[] args) {
        for (Event event: getMovies()) {
            validEvent(event);
        }

        for (Event event: getTheatres()) {
            validEvent(event);
        }

        System.out.println("Все события корректны");
    }

    private static void validEvent(Event event) {
        if (event.getTitle() == null || event.getReleaseYear() == 0 || event.getAge() == 0) {
            throw new RuntimeException("Some " + event.getClass().getSimpleName() + " is not valid");
        }
    }

    private static Movie[] getMovies() {
        return new Movie[] {
                new Movie("Назад в будущее 1", 1985, 12),
                new Movie("Криминальное чтиво", 1994, 18),
                new Movie("El Camino: Во все тяжкие", 2019, 16),
                //new Movie(null, 1, 1),
                //new Movie("1", 0, 1),
                //new Movie("1", 1, 0),
        };
    }

    private static Theatre[] getTheatres() {
        return new Theatre[] {
                new Theatre("Анна Каренина", 2017, 16),
                new Theatre("Суини Тодд, демон-парикмахер с Флит-стрит", 1979, 18),
                new Theatre("Привидение", 2011, 12),
                //new Theatre(null, 1, 1),
                //new Theatre("1", 0, 1),
                //new Theatre("1", 1, 0),
        };
    }
}