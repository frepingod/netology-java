package ru.netology.core.homework07.task2.service.alert;

public class SendAlertServiceImpl implements SendAlertService {

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}