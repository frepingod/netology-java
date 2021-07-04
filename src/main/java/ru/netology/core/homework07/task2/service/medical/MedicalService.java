package ru.netology.core.homework07.task2.service.medical;

import ru.netology.core.homework07.task2.entity.BloodPressure;

import java.math.BigDecimal;

public interface MedicalService {

    void checkBloodPressure(String patientId, BloodPressure bloodPressure);

    void checkTemperature(String patientId, BigDecimal temperature);
}