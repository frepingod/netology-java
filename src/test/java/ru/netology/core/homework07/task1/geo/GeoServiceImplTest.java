package ru.netology.core.homework07.task1.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.core.homework07.task1.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @ValueSource(strings = {GeoServiceImpl.MOSCOW_IP, GeoServiceImpl.NEW_YORK_IP})
    void byIp(String ip) {
        Country country = ip.startsWith("172.") ? Country.RUSSIA : Country.USA;
        assertNotNull(geoService.byIp(ip));
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