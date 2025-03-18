package entities;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class Account {
    private final UUID id;
    private double balance;
    private final List<Transaction> transactionList;

    public Account(double dengi) {
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


    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    @Override
    public String toString() {
        return "account{" +
                "user_id=" + id +
                ", balance=" + balance +
                "}";
    }


}
