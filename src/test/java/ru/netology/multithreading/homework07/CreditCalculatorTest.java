package ru.netology.multithreading.homework07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditCalculatorTest {

    private final CreditCalculator creditCalculator = new CreditCalculator();

    private static final int CREDIT_AMOUNT = 200_000;
    private static final int TERM_IN_MONTHS = 24;
    private static final double CREDIT_RATE = 9.5;

    private static final double MONTHLY_INTEREST_RATE = CREDIT_RATE / 100 / 12;
    private static final double POW = Math.pow(1 + MONTHLY_INTEREST_RATE, TERM_IN_MONTHS);
    private static final double ANNUITY_COEFFICIENT = (MONTHLY_INTEREST_RATE * POW) / (POW - 1);
    private static final int MONTHLY_PAYMENT = (int) Math.round(CREDIT_AMOUNT * ANNUITY_COEFFICIENT);

    @Test
    void monthlyPayment() {
        assertEquals(MONTHLY_PAYMENT, creditCalculator.monthlyPayment(CREDIT_AMOUNT, TERM_IN_MONTHS, CREDIT_RATE));
    }

    @Test
    void totalAmount() {
        assertEquals(MONTHLY_PAYMENT * TERM_IN_MONTHS, creditCalculator.totalAmount(CREDIT_AMOUNT, TERM_IN_MONTHS, CREDIT_RATE));
    }

    @Test
    void overpayment() {
        assertEquals(MONTHLY_PAYMENT * TERM_IN_MONTHS - CREDIT_AMOUNT, creditCalculator.overpayment(CREDIT_AMOUNT, TERM_IN_MONTHS, CREDIT_RATE));
    }
}