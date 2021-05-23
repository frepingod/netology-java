package ru.netology.basics.homework9.task2.accounts;

public class SavingsAccount extends Account {
    public SavingsAccount(int balance) {
        super(balance);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Со сберегательного счета нельзя оплачивать!");
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