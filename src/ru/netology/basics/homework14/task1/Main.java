package ru.netology.basics.homework14.task1;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Contacts CONTACTS = new Contacts();
    private static final MissedCalls MISSED_CALLS = new MissedCalls();

    public static void main(String[] args) {
        while (true) {
            printHead();
            String input = SCANNER.nextLine();

            if ("end".equals(input)) {
                System.out.println("Всего доброго!");
                SCANNER.close();
                break;
            }

            if (!isNumber(input)) {
                System.err.println("Некорректные данные, повторите попытку!");
                continue;
            }

            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.println("Введите: 'Имя, Фамилию, Телефон, Группу'");
                    String data = SCANNER.nextLine().trim();
                    String[] contactData = data.split(", ");

                    if (contactData.length != 4) {
                        System.err.println("Некорректные данные, повторите попытку!");
                        continue;
                    }

                    System.out.println(CONTACTS.add(contactData[0], contactData[1], contactData[2], contactData[3]) ?
                            "Добавлен!" : "Не добавлен!");
                    break;
                case 2:
                    System.out.println("Добавьте номер пропущенного вызова:");
                    String missedCall = SCANNER.nextLine();
                    MISSED_CALLS.addMissedCall(missedCall);
                    System.out.println("Добавлен!");
                    break;
                case 3:
                    System.out.println(MISSED_CALLS.toString());
                    break;
                case 4:
                    MISSED_CALLS.clearMissedCalls();
                    System.out.println("Очищены!");
                    break;
                case 5:
                    System.out.println("Введите: 'Имя, Фамилию'");
                    String name = SCANNER.nextLine().trim();
                    String[] nameData = name.split(", ");

                    if (nameData.length != 2) {
                        System.err.println("Некорректные данные, повторите попытку!");
                        continue;
                    }

                    System.out.println(CONTACTS.delete(nameData[0], nameData[1]) ? "Удален!" : "Не удален!");
                    break;
                case 6:
                    System.out.println("Введите номер телефона");
                    String phone = SCANNER.nextLine();
                    System.out.println(CONTACTS.find(phone));
                    break;
                case 7:
                    System.out.println(CONTACTS);
                    break;
                case 8:
                    System.out.println("Введите: 'Новое имя, новую фамилию, старый телефон, новую группу'");
                    System.out.println("Вводите старое значение тех полей, что не собираетесь менять");
                    String newContact = SCANNER.nextLine().trim();
                    String[] newContactData = newContact.split(", ");

                    if (newContactData.length != 4) {
                        System.err.println("Некорректные данные, повторите попытку!");
                        continue;
                    }

                    System.out.println(CONTACTS.edit(newContactData[0], newContactData[1], newContactData[2], newContactData[3]) ?
                            "Изменен!" : "Не изменен!");
                    break;
                default:
                    System.err.println("Некорректные данные, повторите попытку!");
            }
        }
    }

    private static void printHead() {
        System.out.println("Меню:");
        System.out.println("1. Добавить контакт");
        System.out.println("2. Добавить пропущенный вызов");
        System.out.println("3. Вывести все пропущенные вызовы");
        System.out.println("4. Очистить пропущенные вызовы");
        System.out.println("5. Удалить контакт по имени и фамилии");
        System.out.println("6. Найти контакт по номеру телефона");
        System.out.println("7. Вывести все контакты");
        System.out.println("8. Изменить контакт в записной книжке");

        System.out.println("'end' - Выход");
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