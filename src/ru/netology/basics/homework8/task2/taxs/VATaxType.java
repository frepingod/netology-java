package ru.netology.basics.homework8.task2.taxs;

import java.math.BigDecimal;

public class VATaxType extends TaxType {
    private static final BigDecimal VA_TAX = BigDecimal.valueOf(0.20);

    public VATaxType() {
        setName("НДС");
    }

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(VA_TAX);
    }
}