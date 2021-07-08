package ru.netology.core.homework07.task1.sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.core.homework07.task1.entity.Country;
import ru.netology.core.homework07.task1.entity.Location;
import ru.netology.core.homework07.task1.geo.GeoService;
import ru.netology.core.homework07.task1.i18n.LocalizationService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {

    private static final String IP_RUSSIA = "172.0.32.11";
    private static final String IP_USA = "96.44.183.149";
    private static final String MESSAGE_RUSSIA = "ПРИВЕТ МОЙ ДОРОГОЙ ТОВАРИЩ";
    private static final String MESSAGE_USA = "HELLO MY DEAR COMRADE";

    private static final Map<String, String> MAP_RUSSIA = Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, IP_RUSSIA);
    private static final Map<String, String> MAP_USA = Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, IP_USA);

    private final GeoService geoService = Mockito.mock(GeoService.class);
    private final LocalizationService localizationService = Mockito.mock(LocalizationService.class);
    private final MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

    @BeforeEach
    void setUp() {
        Mockito.when(geoService.byIp(IP_RUSSIA))
                .thenReturn(new Location("city1", Country.RUSSIA, "street1", 1));
        Mockito.when(geoService.byIp(IP_USA))
                .thenReturn(new Location("city2", Country.USA, "street2", 2));
        Mockito.when(geoService.byCoordinates(1.0, 1.0))
                .thenThrow(new RuntimeException("not impl"));

        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(MESSAGE_RUSSIA);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn(MESSAGE_USA);
    }

    @Test
    void sendSuccess() {
        assertEquals(messageSender.send(MAP_RUSSIA), MESSAGE_RUSSIA);
        assertEquals(messageSender.send(MAP_USA), MESSAGE_USA);
    }

    @Test
    void sendUnsuccess() {
        assertNotEquals(messageSender.send(MAP_RUSSIA), MESSAGE_USA);
        assertNotEquals(messageSender.send(MAP_USA), MESSAGE_RUSSIA);
    }
}