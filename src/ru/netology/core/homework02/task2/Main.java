package ru.netology.core.homework02.task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = getCollectionPersons();

        long minorsCount = persons.stream()
                .filter(p -> p.getAge() < 18)
                .count();

        List<String> conscriptsFamilys = persons.stream()
                .filter(p -> p.getSex().equals(Sex.MAN))
                .filter(p -> p.getAge() >= 18 && p.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        List<Person> workablesWithHigherEducation = persons.stream()
                .filter(p -> p.getEducation().equals(Education.HIGHER))
                .filter(p -> (p.getSex().equals(Sex.WOMAN) && p.getAge() >= 18 && p.getAge() <= 60)
                        || (p.getSex().equals(Sex.MAN) && p.getAge() >= 18 && p.getAge() <= 65))
                .sorted(Comparator.comparing(Person::getFamily).thenComparing(Person::getName))
                .collect(Collectors.toList());
    }

    private static Collection<Person> getCollectionPersons() {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        return IntStream.range(0, 10_000_000)
                .mapToObj(i -> new Person(
                        names.get(new Random().nextInt(names.size())),
                        families.get(new Random().nextInt(families.size())),
                        new Random().nextInt(100),
                        Sex.values()[new Random().nextInt(Sex.values().length)],
                        Education.values()[new Random().nextInt(Education.values().length)]))
                .collect(Collectors.toList());
    }
}