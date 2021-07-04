package ru.netology.core.homework07.task1;

import java.util.HashMap;
import java.util.Map;

import ru.netology.core.homework07.task1.geo.GeoService;
import ru.netology.core.homework07.task1.geo.GeoServiceImpl;
import ru.netology.core.homework07.task1.i18n.LocalizationService;
import ru.netology.core.homework07.task1.i18n.LocalizationServiceImpl;
import ru.netology.core.homework07.task1.sender.MessageSender;
import ru.netology.core.homework07.task1.sender.MessageSenderImpl;

public class Main {

    //Тестовый пример
    public static void main(String[] args) {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers);
    }
}