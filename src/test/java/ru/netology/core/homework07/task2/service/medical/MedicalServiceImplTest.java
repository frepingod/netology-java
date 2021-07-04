package ru.netology.core.homework07.task2.service.medical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import ru.netology.core.homework07.task2.entity.BloodPressure;
import ru.netology.core.homework07.task2.entity.HealthInfo;
import ru.netology.core.homework07.task2.entity.PatientInfo;
import ru.netology.core.homework07.task2.repository.PatientInfoFileRepository;
import ru.netology.core.homework07.task2.service.alert.SendAlertService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MedicalServiceImplTest {

    private final String patientId = "1-1-1-1";
    private final BigDecimal patientNormalTemperature = new BigDecimal("36.6");
    private final BloodPressure patientNormalBloodPressure = new BloodPressure(120, 80);
    private final PatientInfo patientInfo = new PatientInfo(patientId, "Иван", "Петров",
            LocalDate.of(1980, 11, 26), new HealthInfo(patientNormalTemperature, patientNormalBloodPressure));

    private final String message = "Warning, patient with id: " + patientId + ", need help";

    private final PatientInfoFileRepository infoMock = Mockito.mock(PatientInfoFileRepository.class);
    private final SendAlertService sendMock = Mockito.mock(SendAlertService.class);
    private final MedicalService medicalService = new MedicalServiceImpl(infoMock, sendMock);
    private final ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    @BeforeEach
    void setUp() {
        Mockito.when(infoMock.getById(patientId)).thenReturn(patientInfo);
        Mockito.doAnswer((Answer<Void>) invocationOnMock -> {
            System.out.println(message);
            return null;
        }).when(sendMock).send(Mockito.any());
    }

    @Test
    void checkTemperature() {
        medicalService.checkTemperature(patientId, new BigDecimal("34.9"));
        Mockito.verify(sendMock).send(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue(), message);
        Mockito.verify(sendMock, Mockito.only()).send(message);
    }

    @Test
    void checkTemperature_normalValue() {
        medicalService.checkTemperature(patientId, patientNormalTemperature);
        Mockito.verify(sendMock, Mockito.never()).send(message);
    }

    @Test
    void checkBloodPressure() {
        medicalService.checkBloodPressure(patientId, new BloodPressure(888, 888));
        Mockito.verify(sendMock).send(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue(), message);
        Mockito.verify(sendMock, Mockito.only()).send(message);
    }

    @Test
    void checkBloodPressure_normalValue() {
        medicalService.checkBloodPressure(patientId, patientNormalBloodPressure);
        Mockito.verify(sendMock, Mockito.never()).send(message);
    }
}