package ru.netology.core.homework07.task1.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.core.homework07.task1.entity.Country;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LocalizationServiceImplTest {

    private final LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void locate() {
        for (Country country : Country.values()) {
            if (country.equals(Country.RUSSIA)) {
                assertFalse(isContainsInvalidChars(localizationService.locale(country), 'A', 'Z'));
            } else {
                assertFalse(isContainsInvalidChars(localizationService.locale(country), 'А', 'Я'));
            }
        }
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