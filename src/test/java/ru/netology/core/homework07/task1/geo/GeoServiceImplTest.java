package ru.netology.core.homework07.task1.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.core.homework07.task1.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @CsvSource({GeoServiceImpl.LOCALHOST + ",", GeoServiceImpl.MOSCOW_IP + ",RUSSIA", GeoServiceImpl.NEW_YORK_IP + ",USA"})
    void byIp(String ip, Country country) {
        assertEquals(geoService.byIp(ip).getCountry(), country);
    }

    @Test
    void byIpInvalidData() {
        assertNull(geoService.byIp("invalidData"));
    }

    @Test
    void byCoordinates() {
        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(1.0, 1.0));
    }
}