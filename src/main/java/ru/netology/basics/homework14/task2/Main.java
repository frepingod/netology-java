package ru.netology.basics.homework14.task2;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Set<Candidate> CANDIDATES = new TreeSet<>(
            Comparator.comparing(Candidate::getRelevance).thenComparing(Candidate::getRating).reversed()
                    .thenComparing(Candidate::getFullName).thenComparing(Candidate::getAge));

    public static void main(String[] args) {
        System.out.println("Использовать готовые тестовые данные? (да/что угодно)");
        String choice = SCANNER.nextLine();

        if ("да".equals(choice)) {
            addCandidates();
        } else {
            okayLetsGo();
        }

        printCandidates(CANDIDATES);
    }

    private static void okayLetsGo() {
        while (true) {
            System.out.println("Введите информацию о кандидате ('end' для завершения):");
            System.out.println("'Фамилия Имя Отчество, пол, возраст, релевантность резюме, оценка на собеседовании'");
            String data = SCANNER.nextLine().trim();

            if ("end".equals(data)) {
                SCANNER.close();
                break;
            }

            String[] candidateData = data.split(", ");
            String[] fullNameData = candidateData[0].split(" ");
            if (fullNameData.length != 3 || candidateData.length != 5
                    || !isNumber(candidateData[2]) || !isNumber(candidateData[3]) || !isNumber(candidateData[4])) {
                System.err.println("Некорректные данные, повторите попытку!");
                continue;
            }

            Candidate candidate = new Candidate(candidateData[0], candidateData[1], Integer.parseInt(candidateData[2]),
                    Integer.parseInt(candidateData[3]), Integer.parseInt(candidateData[4]));
            CANDIDATES.add(candidate);
            System.out.println("Кандидат успешно добавлен!");
        }
    }

    private static void printCandidates(Set<Candidate> candidates) {
        if (candidates.isEmpty()) {
            System.out.println("Список кандидатов пуст!");
        } else {
            System.out.println("ФИО, Релевантность резюме, Оценка на собеседовании:");
            for (Candidate candidate : candidates) {
                System.out.format("\t- %s, %d, %d\n",
                        candidate.getFullName(), candidate.getRelevance(), candidate.getRating());
            }
        }
    }

    private static void addCandidates() {
        CANDIDATES.add(new Candidate("Иванов Иван Иванович", "муж", 25, 4, 5));
        CANDIDATES.add(new Candidate("Петров Петр Петрович", "жен", 20, 4, 3));
        CANDIDATES.add(new Candidate("Сергеев Сергей Сергеевич", "муж", 27, 5, 2));
        CANDIDATES.add(new Candidate("Андреев Андрей Андреевич", "жен", 35, 3, 999));
        CANDIDATES.add(new Candidate("Жуков Жук Жукович", "муж", 40, 2, -79));
        CANDIDATES.add(new Candidate("Семенов Семен Семенович", "жен", 45, 15, 0));
        CANDIDATES.add(new Candidate("Михайлов Михаил Михайлович", "муж", 55, -8, 5));
        CANDIDATES.add(new Candidate("Артемов Артем Артемович", "жен", 15, 0, 5));
        CANDIDATES.add(new Candidate("Иванов Иван Иванович", "муж", 18, 1, 4));
        CANDIDATES.add(new Candidate("Иванов Иван Иванович", "жен", 99, 1, 3));
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}