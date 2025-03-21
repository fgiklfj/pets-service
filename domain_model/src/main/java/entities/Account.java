package entities;

import exceptions.InvalidAccountAmountDepositOrWithdrawException;
import exceptions.InvalidAccountAmountException;
import exceptions.InvalidAccountWithdrawException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private final UUID id;
    private double balance;
    private final List<Transaction> transactionList;

    public Account(double dengi) throws InvalidAccountAmountException {
        if (dengi < 0)
            throw new InvalidAccountAmountException("Initial balance cannot be negative");

        this.id = UUID.randomUUID();
        this.balance = dengi;
        this.transactionList = new ArrayList<Transaction>();
    }

    public UUID getID() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAccountAmountDepositOrWithdrawException {
        if (amount <= 0)
            throw new InvalidAccountAmountDepositOrWithdrawException("You must use positive number!");

        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAccountAmountDepositOrWithdrawException, InvalidAccountWithdrawException {
        if (amount <= 0)
            throw new InvalidAccountAmountDepositOrWithdrawException("You must use positive number!");

        if (amount > balance)
            throw new InvalidAccountWithdrawException("Insufficient funds");

        balance -= amount;
    }

    @Override
    public String toString() {
        return "account{user_id=" + id + ", balance=" + balance + "}";
    }


}
