package ru.netology.basics.homework08.task2;

import java.math.BigDecimal;

public class TaxService {
    public void payOut(BigDecimal amount, String name, BigDecimal taxAmount) {
        System.out.print("С суммы " + amount + " уплачен " + name);
        System.out.format(" в размере %.2f%n", taxAmount);
    }
}