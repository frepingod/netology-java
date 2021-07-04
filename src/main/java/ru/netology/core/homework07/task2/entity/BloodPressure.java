package ru.netology.core.homework07.task2.entity;

import java.util.Objects;

public class BloodPressure {

    private int high;
    private int low;

    public BloodPressure() {
    }

    public BloodPressure(int high, int low) {
        this.high = high;
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    @Override
    public String toString() {
        return "BloodPressure{" +
                "high=" + high +
                ", low=" + low +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodPressure that = (BloodPressure) o;
        return high == that.high && low == that.low;
    }

    @Override
    public int hashCode() {
        return Objects.hash(high, low);
    }
}