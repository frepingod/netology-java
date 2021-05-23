package ru.netology.basics.homework11.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            Employee employee = createEmployee();
            employees.add(employee);

            System.out.println("'end' - если хотите закончить ввод данных");
            System.out.println("'change'- если хотите изменить данные сотрудника");
            System.out.println("либо введите что-угодно другое для продолжение");

            String choice = SCANNER.nextLine();

            if ("end".equals(choice)) {
                printEmployees(employees);
                SCANNER.close();
                break;
            }

            if ("change".equals(choice)) {
                while (true) {
                    System.out.println("Введите фамилию работника, для которого хотите изменить данные:");
                    String surname = SCANNER.nextLine();

                    System.out.println("Введите имя работника, для которого хотите изменить данные:");
                    String name = SCANNER.nextLine();

                    int empIndex = searchBySurname(surname, name, employees);

                    if (empIndex == -1) {
                        System.out.println("Такой сотрудник не найден!");
                        break;
                    }

                    if (empIndex != -1) {
                        String str = "";

                        System.out.println("Меняем фамилию сотрудника? Да/Нет");
                        str = SCANNER.nextLine();
                        if ("Да".equals(str)) {
                            System.out.println("Введите фамилию сотрудника:");
                            employees.get(empIndex).setSurname(SCANNER.nextLine());
                        }

                        System.out.println("Меняем имя сотрудника? Да/Нет");
                        str = SCANNER.nextLine();
                        if ("Да".equals(str)) {
                            System.out.println("Введите имя сотрудника:");
                            employees.get(empIndex).setName(SCANNER.nextLine());
                        }

                        System.out.println("Меняем возраст сотрудника? Да/Нет");
                        str = SCANNER.nextLine();
                        if ("Да".equals(str)) {
                            System.out.println("Введите возраст сотрудника:");
                            employees.get(empIndex).setAge(Integer.parseInt(SCANNER.nextLine()));
                        }

                        System.out.println("Меняем пол сотрудника? Да/Нет");
                        str = SCANNER.nextLine();
                        if ("Да".equals(str)) {
                            System.out.println("Введите пол сотрудника:");
                            employees.get(empIndex).setSex(SCANNER.nextLine());
                        }

                        System.out.println("Меняем образование сотрудника? Да/Нет");
                        str = SCANNER.nextLine();
                        if ("Да".equals(str)) {
                            System.out.println("Введите образование сотрудника:");
                            employees.get(empIndex).setEducation(SCANNER.nextLine());
                        }

                        System.out.println("Меняем должность сотрудника? Да/Нет");
                        str = SCANNER.nextLine();
                        if ("Да".equals(str)) {
                            System.out.println("Введите должность сотрудника:");
                            employees.get(empIndex).setPosition(SCANNER.nextLine());
                        }

                        System.out.println("Меняем отдел сотрудника? Да/Нет");
                        str = SCANNER.nextLine();
                        if ("Да".equals(str)) {
                            System.out.println("Введите отдел сотрудника:");
                            employees.get(empIndex).setDepartment(SCANNER.nextLine());
                        }
                    }

                    break;
                }
            }
        }
    }

    private static Employee createEmployee() {
        System.out.println("Создаем сотрудника:");

        System.out.println("Введите фамилию сотрудника:");
        String surname = SCANNER.nextLine();

        System.out.println("Введите имя сотрудника:");
        String name = SCANNER.nextLine();

        System.out.println("Введите возраст сотрудника:");
        int age = Integer.parseInt(SCANNER.nextLine());

        System.out.println("Введите пол сотрудника:");
        String sex = SCANNER.nextLine();

        System.out.println("Введите образование сотрудника:");
        String education = SCANNER.nextLine();

        System.out.println("Введите должность сотрудника:");
        String position = SCANNER.nextLine();

        System.out.println("Введите отдел сотрудника:");
        String department = SCANNER.nextLine();

        return new Employee(surname, name, age, sex, education, position, department);
    }

    private static void printEmployees(List<Employee> employees) {
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int searchBySurname(String surname, String name, List<Employee> employeeList) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getSurname().equals(surname) && employeeList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}