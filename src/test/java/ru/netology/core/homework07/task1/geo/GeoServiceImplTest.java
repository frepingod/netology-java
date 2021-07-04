package ru.netology.core.homework07.task1.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @ValueSource(strings = {GeoServiceImpl.LOCALHOST, GeoServiceImpl.MOSCOW_IP, GeoServiceImpl.NEW_YORK_IP})
    void byIp(String ip) {
        assertNotNull(geoService.byIp(ip));
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