package ru.netology.core.homework07.task1.sender;

import java.util.Map;

public interface MessageSender {

    String send(Map<String, String> headers);
}