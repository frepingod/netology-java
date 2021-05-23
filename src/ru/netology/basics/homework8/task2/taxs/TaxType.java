package ru.netology.basics.homework8.task2.taxs;

import java.math.BigDecimal;

public abstract class TaxType {
    private String name;

    public abstract BigDecimal calculateTaxFor(BigDecimal amount);

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}