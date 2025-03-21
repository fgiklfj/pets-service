package entities;

import exceptions.ATMExceptionDomainModel;
import exceptions.InvalidAccountAmountDepositOrWithdrawException;
import exceptions.InvalidAccountAmountException;
import exceptions.InvalidAccountWithdrawException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() throws ATMExceptionDomainModel {
        account = new Account(BigDecimal.valueOf(100.00));
    }

    @Test
    void testAccountCreationWithNegativeBalanceThrowsException() {
        assertThrows(InvalidAccountAmountException.class,
                () -> new Account(BigDecimal.valueOf(-50.00)),
                "Initial balance cannot be negative");
    }

    @Test
    void testDepositValidAmount() throws ATMExceptionDomainModel {
        account.deposit(BigDecimal.valueOf(50.00));
        assertEquals(0, account.getBalance().compareTo(BigDecimal.valueOf(150.00)),
                "Balance should increase by deposit amount");
    }

    @Test
    void testWithdrawValidAmount() throws ATMExceptionDomainModel {
        account.withdraw(BigDecimal.valueOf(30.00));
        assertEquals(0, account.getBalance().compareTo(BigDecimal.valueOf(70.00)),
                "Balance should decrease by withdrawn amount");
    }

    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        assertThrows(InvalidAccountWithdrawException.class,
                () -> account.withdraw(BigDecimal.valueOf(200.00)),
                "Withdrawing more than balance should throw exception");
    }

    @Test
    void testDepositNegativeAmountThrowsException() {
        assertThrows(InvalidAccountAmountDepositOrWithdrawException.class,
                () -> account.deposit(BigDecimal.valueOf(-20.00)),
                "Depositing a negative amount should throw exception");
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        assertThrows(InvalidAccountAmountDepositOrWithdrawException.class,
                () -> account.withdraw(BigDecimal.valueOf(-10.00)),
                "Withdrawing a negative amount should throw exception");
    }
}
