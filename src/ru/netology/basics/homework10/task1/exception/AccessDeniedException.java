package ru.netology.basics.homework10.task1.exception;

public class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}