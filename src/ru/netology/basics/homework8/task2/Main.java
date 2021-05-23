package ru.netology.basics.homework8.task2;

import ru.netology.basics.homework8.task2.taxs.IncomeTaxType;
import ru.netology.basics.homework8.task2.taxs.ProgressiveTaxType;
import ru.netology.basics.homework8.task2.taxs.VATaxType;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        TaxService taxService = new TaxService();

        Bill[] payments = new Bill[] {
                new Bill(BigDecimal.valueOf(100_000.00), new ProgressiveTaxType(), taxService),
                new Bill(BigDecimal.valueOf(101_000.00), new ProgressiveTaxType(), taxService),
                new Bill(BigDecimal.valueOf(66_000.00), new IncomeTaxType(), taxService),
                new Bill(BigDecimal.valueOf(3_000.00), new VATaxType(), taxService)
        };

        for (Bill bill : payments) {
            bill.payTaxes();
        }
    }
}