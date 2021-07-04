package ru.netology.core.homework07.task1.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.core.homework07.task1.entity.Country;
import ru.netology.core.homework07.task1.entity.Location;
import ru.netology.core.homework07.task1.geo.GeoService;
import ru.netology.core.homework07.task1.i18n.LocalizationService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {

    private static final String IP_RUSSIA = "B.O.R.S.C.H.T";
    private static final String IP_USA = "B.U.R.G.E.R";
    private static final String MESSAGE_RUSSIA = "ПРИВЕТ МОЙ ДОРОГОЙ ТОВАРИЩ";
    private static final String MESSAGE_USA = "HELLO MY DEAR COMRADE";

    private static final Map<String, String> MAP_RUSSIA = Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, IP_RUSSIA);
    private static final Map<String, String> MAP_USA = Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, IP_USA);

    @Test
    void send() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(IP_RUSSIA))
                .thenReturn(new Location("city1", Country.RUSSIA, "street1", 1));
        Mockito.when(geoService.byIp(IP_USA))
                .thenReturn(new Location("city2", Country.USA, "street2", 2));
        Mockito.when(geoService.byCoordinates(1.0, 1.0))
                .thenThrow(new RuntimeException("not impl"));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(MESSAGE_RUSSIA);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn(MESSAGE_USA);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        assertEquals(messageSender.send(MAP_RUSSIA), MESSAGE_RUSSIA);
        assertEquals(messageSender.send(MAP_USA), MESSAGE_USA);
        assertNotEquals(messageSender.send(MAP_RUSSIA), MESSAGE_USA);
        assertNotEquals(messageSender.send(MAP_USA), MESSAGE_RUSSIA);
    }
}