package domainmodel.entities;

import domainmodel.exceptions.ATMExceptionDomainModel;
import domainmodel.exceptions.InvalidAccountAmountDepositOrWithdrawException;
import domainmodel.exceptions.InvalidAccountAmountException;
import domainmodel.exceptions.InvalidAccountWithdrawException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private final UUID id;
    private BigDecimal balance;
    private final List<Transaction> transactionList;

    public Account(BigDecimal dengi) throws ATMExceptionDomainModel {
        if (dengi.compareTo(BigDecimal.ZERO) < 0)
            throw new InvalidAccountAmountException("Initial balance cannot be negative");

        this.id = UUID.randomUUID();
        this.balance = dengi;
        this.transactionList = new ArrayList<Transaction>();
    }

    public UUID getID() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) throws ATMExceptionDomainModel {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAccountAmountDepositOrWithdrawException("You must use positive number!");

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws ATMExceptionDomainModel {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAccountAmountDepositOrWithdrawException("You must use positive number!");

        if (amount.compareTo(balance) > 0)
            throw new InvalidAccountWithdrawException("Insufficient funds");

        balance = balance.subtract(amount);
    }

    @Override
    public String toString() {
        return "account{user_id=" + id + ", balance=" + balance + "}";
    }


}
