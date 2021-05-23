package ru.netology.basics.homework8.task2;

import ru.netology.basics.homework8.task2.taxs.TaxType;

import java.math.BigDecimal;

public class Bill {
    private BigDecimal amount;
    private TaxType taxType;
    private TaxService taxService;

    public Bill(BigDecimal amount, TaxType taxType, TaxService taxService) {
        this.amount = amount;
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public void payTaxes() {
        String taxName = taxType.getName();
        BigDecimal taxAmount = taxType.calculateTaxFor(amount);
        taxService.payOut(amount, taxName, taxAmount);
    }
}