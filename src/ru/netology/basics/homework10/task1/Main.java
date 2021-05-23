package ru.netology.basics.homework10.task1;

import ru.netology.basics.homework10.task1.exception.AccessDeniedException;
import ru.netology.basics.homework10.task1.exception.UserNotFoundException;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        System.out.println("Введите логин");
        String login = SCANNER.nextLine();

        System.out.println("Введите пароль");
        String password = SCANNER.nextLine();

        validateUser(getUserByLoginAndPassword(login, password));

        System.out.println("Доступ предоставлен");
        SCANNER.close();
    }

    private static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        for (User user : getUsers()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        throw new UserNotFoundException("User not found");
    }

    private static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("The user is less than 18 y.o.");
        }
    }

    private static User[] getUsers() {
        return new User[] {
                new User("jhon", "pass", "jhon@gmail.com", 24),
                new User("user_login", "user_pass", "user@user.user", 67),
                new User("admin_login", "admin_pass", "admin@admin.admin", 16),
                new User("ivan", "NEivan", "balalayka@ya.ru", 55)
        };
    }
}