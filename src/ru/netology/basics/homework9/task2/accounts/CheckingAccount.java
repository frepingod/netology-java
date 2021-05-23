package ru.netology.basics.homework9.task2.accounts;

public class CheckingAccount extends Account {
    public CheckingAccount(int balance) {
        super(balance);
    }

    @Override
    public void pay(int amount) {
        if (balance < amount) {
            System.out.println("Недостаточно средств для оплаты!");
        } else {
            super.pay(amount);
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        if (balance < amount) {
            System.out.println("Недостаточно средств для перевода!");
        } else {
            super.transfer(account, amount);
        }
    }
}