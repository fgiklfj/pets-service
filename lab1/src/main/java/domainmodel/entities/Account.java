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

    /**
     * @return the unique identifier of this account
     */
    public UUID getID() {
        return id;
    }

    /**
     * Returns the current balance of this account.
     *
     * @return the account balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Increases the balance of the account by the given amount.
     * If the given amount is not positive, throws InvalidAccountAmountDepositOrWithdrawException.
     *
     * @param amount the amount to increase the balance by
     * @throws ATMExceptionDomainModel
     */
    public void deposit(BigDecimal amount) throws ATMExceptionDomainModel {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAccountAmountDepositOrWithdrawException("You must use positive number!");

        balance = balance.add(amount);
    }

    /**
     * Decreases the balance of the account by the given amount.
     * If the given amount is not positive, throws InvalidAccountAmountDepositOrWithdrawException.
     * If the given amount is larger than the current balance, throws InvalidAccountWithdrawException.
     *
     * @param amount the amount to decrease the balance by
     * @throws ATMExceptionDomainModel
     */
    public void withdraw(BigDecimal amount) throws ATMExceptionDomainModel {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAccountAmountDepositOrWithdrawException("You must use positive number!");

        if (amount.compareTo(balance) > 0)
            throw new InvalidAccountWithdrawException("Insufficient funds");

        balance = balance.subtract(amount);
    }

    /**
     * Returns a string representation of the object. In general, the .toString()
     * method returns a string that "textually represents" this object. The result
     * should be a concise but informative representation that is easy for a
     * person to read.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "account{user_id=" + id + ", balance=" + balance + "}";
    }
}
