package ru.netology.core.homework07.task1.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.core.homework07.task1.entity.Country;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LocalizationServiceImplTest {

    private final LocalizationService localizationService = new LocalizationServiceImpl();

    @ParameterizedTest
    @MethodSource("locateData")
    void locate(Country country, char start, char end) {
        assertFalse(isContainsInvalidChars(localizationService.locale(country), start, end));
    }

    private static Stream<Arguments> locateData() {
        return Stream.of(
                arguments(Country.RUSSIA, 'A', 'Z'),
                arguments(Country.USA, 'А', 'Я'),
                arguments(Country.BRAZIL, 'А', 'Я')
        );
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