package ru.netology.core.homework07.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import ru.netology.core.homework07.task2.entity.BloodPressure;
import ru.netology.core.homework07.task2.entity.HealthInfo;
import ru.netology.core.homework07.task2.entity.PatientInfo;
import ru.netology.core.homework07.task2.repository.PatientInfoFileRepository;
import ru.netology.core.homework07.task2.repository.PatientInfoRepository;
import ru.netology.core.homework07.task2.service.alert.SendAlertService;
import ru.netology.core.homework07.task2.service.alert.SendAlertServiceImpl;
import ru.netology.core.homework07.task2.service.medical.MedicalService;
import ru.netology.core.homework07.task2.service.medical.MedicalServiceImpl;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules(new JavaTimeModule(), new ParameterNamesModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        File repoFile = new File("./src/main/java/ru/netology/core/homework07/task2/patients.txt");
        PatientInfoRepository patientInfoRepository = new PatientInfoFileRepository(repoFile, mapper);

        String id1 = patientInfoRepository.add(
                new PatientInfo("Иван", "Петров", LocalDate.of(1980, 11, 26),
                        new HealthInfo(new BigDecimal("36.65"), new BloodPressure(120, 80)))
        );

        String id2 = patientInfoRepository.add(
                new PatientInfo("Семен", "Михайлов", LocalDate.of(1982, 1, 16),
                        new HealthInfo(new BigDecimal("36.6"), new BloodPressure(125, 78)))
        );

        SendAlertService alertService = new SendAlertServiceImpl();
        MedicalService medicalService = new MedicalServiceImpl(patientInfoRepository, alertService);

        //run service
        BloodPressure currentPressure = new BloodPressure(60, 120);
        medicalService.checkBloodPressure(id1, currentPressure);

        BigDecimal currentTemperature = new BigDecimal("37.9");
        medicalService.checkTemperature(id1, currentTemperature);
    }
}