package ru.netology.basics.homework9.task2;

import ru.netology.basics.homework9.task2.accounts.Account;
import ru.netology.basics.homework9.task2.accounts.CheckingAccount;
import ru.netology.basics.homework9.task2.accounts.CreditAccount;
import ru.netology.basics.homework9.task2.accounts.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Account checkingAccount = new CheckingAccount(50_000);
        Account creditAccount = new CreditAccount(-50_000);
        Account savingsAccount = new SavingsAccount(50_000);

        forAccountTest(checkingAccount);
        forAccountTest(creditAccount);
        forAccountTest(savingsAccount);
    }

    private static void forAccountTest(Account account) {
        System.out.format("!!! %s !!!\n", account.getClass().getSimpleName());

        account.pay(50_001);
        account.pay(45_000);

        account.transfer(new SavingsAccount(100), 1_000);
        account.transfer(new SavingsAccount(100), 50_000);

        account.addMoney(999_999);

        System.out.println("********************************************************************************");
    }
}