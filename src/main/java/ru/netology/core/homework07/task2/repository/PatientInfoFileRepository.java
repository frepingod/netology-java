package ru.netology.core.homework07.task2.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.netology.core.homework07.task2.entity.PatientInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.UUID;

public class PatientInfoFileRepository implements PatientInfoRepository {

    private final File repoFile;
    private final ObjectMapper mapper;

    public PatientInfoFileRepository(File repoFile, ObjectMapper mapper) {
        createRepoFileIfNotExists(repoFile);
        this.repoFile = repoFile;
        this.mapper = mapper;
    }

    @Override
    public PatientInfo getById(String id) {
        try (Scanner scanner = new Scanner(repoFile)) {
            while (scanner.hasNextLine()) {
                PatientInfo patientInfo = mapper.readValue(scanner.nextLine(), PatientInfo.class);
                if (patientInfo.getId().equals(id)) {
                    return patientInfo;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String add(PatientInfo patientInfo) {
        PatientInfo info = new PatientInfo(UUID.randomUUID().toString(),
                patientInfo.getName(),
                patientInfo.getSurname(),
                patientInfo.getBirthday(),
                patientInfo.getHealthInfo());

        try (Scanner scanner = new Scanner(repoFile); FileWriter writer = new FileWriter(repoFile, true)) {
            while (scanner.hasNextLine()) {
                PatientInfo existsValue = mapper.readValue(scanner.nextLine(), PatientInfo.class);
                if (isPatientExist(patientInfo, existsValue)) {
                    throw new RuntimeException("Patient already exists");
                }
            }
            String serializedPatientInfo = mapper.writeValueAsString(info);
            writer.append(String.format("%s%n", serializedPatientInfo));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return info.getId();
    }

    private static boolean isPatientExist(PatientInfo patientInfo, PatientInfo existsValue) {
        return existsValue.getBirthday().equals(patientInfo.getBirthday())
                && existsValue.getHealthInfo().equals(patientInfo.getHealthInfo())
                && existsValue.getName().equals(patientInfo.getName())
                && existsValue.getSurname().equals(patientInfo.getSurname());
    }

    @Override
    public PatientInfo remove(String id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public PatientInfo update(PatientInfo patientInfo) {
        throw new RuntimeException("Not implemented");
    }

    private static void createRepoFileIfNotExists(File repoFile) {
        if (!Files.exists(repoFile.toPath())) {
            try {
                Files.createFile(repoFile.toPath());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}