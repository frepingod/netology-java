package ru.netology.multithreading.homework07;

public class CreditCalculator {

    public int monthlyPayment(int creditAmount, int termInMonths, double creditRate) {
        double monthlyInterestRate = monthlyInterestRate(creditRate);
        double annuityCoefficient = annuityCoefficient(termInMonths, monthlyInterestRate);
        return (int) Math.round(creditAmount * annuityCoefficient);
    }

    public int totalAmount(int creditAmount, int termInMonths, double creditRate) {
        return monthlyPayment(creditAmount, termInMonths, creditRate) * termInMonths;
    }

    public int overpayment(int creditAmount, int termInMonths, double creditRate) {
        return totalAmount(creditAmount, termInMonths, creditRate) - creditAmount;
    }

    protected double monthlyInterestRate(double creditRate) {
        return creditRate / 100 / 12;
    }

    protected double annuityCoefficient(int termInMonths, double monthlyInterestRate) {
        double pow = Math.pow(1 + monthlyInterestRate, termInMonths);
        return (monthlyInterestRate * pow) / (pow - 1);
    }
}