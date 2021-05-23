package ru.netology.basics.homework8.task2.taxs;

import java.math.BigDecimal;

public class IncomeTaxType extends TaxType {
    private static final BigDecimal INCOME_TAX = BigDecimal.valueOf(0.13);

    public IncomeTaxType() {
        setName("Подоходный налог");
    }

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(INCOME_TAX);
    }
}