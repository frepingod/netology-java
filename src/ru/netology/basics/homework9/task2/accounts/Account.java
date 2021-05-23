package ru.netology.basics.homework9.task2.accounts;

public abstract class Account {
    protected int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void pay(int amount) {
        balance -= amount;
        printResultOperation(amount, balance);
    }

    public void transfer(Account account, int amount) {
        account.balance += amount;
        balance -= amount;
        printResultOperation(amount, balance);
    }

    public void addMoney(int amount) {
        balance += amount;
        printResultOperation(amount, balance);
    }

    private void printResultOperation(int amount, int balance) {
        System.out.println("Произведена операция на сумму: " + amount);
        System.out.println("Текущий баланс: " + balance);
    }
}