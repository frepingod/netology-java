package ru.netology.core.homework07.task2.repository;

import ru.netology.core.homework07.task2.entity.PatientInfo;

public interface PatientInfoRepository {

    PatientInfo getById(String id);

    String add(PatientInfo patientInfo);

    PatientInfo remove(String id);

    PatientInfo update(PatientInfo patientInfo);
}