package ru.netology.basics.homework13.task1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static PhoneContacts phoneContacts = new PhoneContacts(new HashMap<>());
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Программа справочник");

        while (true) {
            System.out.println(phoneContacts.isEmpty() ? "Введите название группы контактов:" :
                    "Создать еще одну группу (введите название или введите нет)?");
            String groupName = SCANNER.nextLine();

            if ("нет".equals(groupName) && !phoneContacts.isEmpty()) {
                break;
            }

            createGroupConsole(groupName);
        }

        while (true) {
            System.out.println("Создаем контакт!");
            System.out.println("Введите: 'наименование : номер телефона' или введите 'нет'");
            String data = SCANNER.nextLine().trim();

            if ("нет".equals(data)) {
                break;
            }

            String[] contactData = data.split(" : ");
            if (contactData.length != 2) {
                System.err.println("Некорректные данные, повторите попытку!");
                continue;
            }

            Contact contact = phoneContacts.createContact(contactData[0], contactData[1]);
            System.out.println("Контакт '" + contact.getName() + "' успешно создан!");

            System.out.println("Укажите, через пробел, группы, в которые будем добавлять контакт:");
            String groupData = SCANNER.nextLine().trim();
            String[] groupNames = groupData.split(" ");

            for (String groupName : groupNames) {
                if (phoneContacts.addContact(contact, groupName)) {
                    System.out.println("Контакт '" + contact.getName() + "' успешно добавлен в группу '" + groupName + "'!");
                } else {
                    System.out.println("Группы '" + groupName + "' не существует, создать ее и добавить туда контакт?");
                    System.out.println("'да' - создать; 'что угодно' - не создавать");
                    String choice = SCANNER.nextLine();

                    if ("да".equals(choice)) {
                        createGroupConsole(groupName);
                        addContactConsole(contact, groupName);
                    }
                }
            }
        }

        System.out.println(phoneContacts);
        SCANNER.close();
    }

    private static void createGroupConsole(String groupName) {
        System.out.println(phoneContacts.createGroup(groupName) ?
                "Группа '" + groupName + "' успешно создана!" : "Группа '" + groupName + "' уже существует!");
    }

    private static void addContactConsole(Contact contact, String groupName) {
        System.out.println(phoneContacts.addContact(contact, groupName) ?
                "Контакт '" + contact.getName() + "' успешно добавлен в группу '" + groupName + "'!" :
                "Группа '" + groupName + "' не существует!");
    }
}