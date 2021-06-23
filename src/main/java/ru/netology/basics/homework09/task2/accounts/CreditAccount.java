package ru.netology.basics.homework09.task2.accounts;

public class CreditAccount extends Account {
    public CreditAccount(int balance) {
        super(balance);
    }

    @Override
    public void addMoney(int amount) {
        if ((-1 * balance) < amount) {
            System.out.println("Нельзя положить лишние деньги!");
        } else {
            super.addMoney(amount);
        }
    }
}