package ru.netology.basics.homework13.task2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Set<Student> STUDENTS = new HashSet<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите информацию о студенте: 'ФИО, номер группы, номер студенческого билета'");
            System.out.println("'end' - для завершения работы программы");
            String data = SCANNER.nextLine().trim();

            if ("end".equals(data)) {
                System.out.println("Всего доброго!");
                SCANNER.close();
                break;
            }

            String[] studentData = data.split(", ");
            if (studentData.length != 3) {
                System.err.println("Некорректные данные, повторите попытку!");
                continue;
            }

            Student student = new Student(studentData[0], studentData[1], studentData[2]);
            System.out.println(STUDENTS.contains(student) ?
                    "Студент с таким номером студенческого билета уже существует!" : "Студент успешно добавлен!");
            STUDENTS.add(student);
        }

        printStudents(STUDENTS);
    }

    public static void printStudents(Set<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст!");
        } else {
            System.out.println("Список студентов:");
            for (Student s : students) {
                System.out.println("\t- " + s);
            }
        }
    }
}