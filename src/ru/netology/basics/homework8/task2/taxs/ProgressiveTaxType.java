package ru.netology.basics.homework8.task2.taxs;

import java.math.BigDecimal;

public class ProgressiveTaxType extends TaxType {
    private static final int LIMIT = 100_000;

    private static final BigDecimal UP_TO = BigDecimal.valueOf(0.10);
    private static final BigDecimal OVER = BigDecimal.valueOf(0.15);

    public ProgressiveTaxType() {
        setName("Прогрессивный налог");
    }

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        BigDecimal tax = (amount.doubleValue() <= LIMIT) ? UP_TO : OVER;
        return amount.multiply(tax);
    }
}