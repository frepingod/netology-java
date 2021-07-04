package ru.netology.core.homework07.task2.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class HealthInfo {

    private BigDecimal normalTemperature;
    private BloodPressure bloodPressure;

    public HealthInfo() {
    }

    public HealthInfo(BigDecimal normalTemperature, BloodPressure bloodPressure) {
        this.normalTemperature = normalTemperature;
        this.bloodPressure = bloodPressure;
    }

    public BigDecimal getNormalTemperature() {
        return normalTemperature;
    }

    public BloodPressure getBloodPressure() {
        return bloodPressure;
    }

    @Override
    public String toString() {
        return "HealthInfo{" +
                "normalTemperature=" + normalTemperature +
                ", bloodPressure=" + bloodPressure +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthInfo that = (HealthInfo) o;
        return normalTemperature.equals(that.normalTemperature) && bloodPressure.equals(that.bloodPressure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normalTemperature, bloodPressure);
    }
}