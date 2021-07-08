package ru.netology.core.homework07.task1.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.core.homework07.task1.entity.Country;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LocalizationServiceImplTest {

    private final LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void locate() {
        for (Country country : Country.values()) {
            char[] startEnd = getTestChars(country);
            assertFalse(isContainsInvalidChars(localizationService.locale(country), startEnd[0], startEnd[1]));
        }
    }

    private char[] getTestChars(Country country) {
        if (country.equals(Country.RUSSIA)) {
            return new char[]{'A', 'Z'}; //english
        }
        return new char[]{'А', 'Я'}; //russian
    }

    private boolean isContainsInvalidChars(String message, char start, char end) {
        for (char i = start; i <= end; i++) {
            if (message.contains(String.valueOf(i).toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}