package ru.netology.core.homework07.task1.i18n;

import ru.netology.core.homework07.task1.entity.Country;

public class LocalizationServiceImpl implements LocalizationService {

    public String locale(Country country) {
        switch (country) {
            case RUSSIA:
                return "Добро пожаловать";
            default:
                return "Welcome";
        }
    }
}