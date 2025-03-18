package entities;

import Exceptions.InvalidAccountAmountDepositOrWithdrawException;
import Exceptions.InvalidAccountAmountException;
import Exceptions.InvalidAccountWithdrawException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() throws InvalidAccountAmountException {
        account = new Account(100.0);
    }

    @Test
    void testAccountCreationWithNegativeBalanceThrowsException() {
        assertThrows(InvalidAccountAmountException.class, () -> new Account(-50.0),
                "Initial balance cannot be negative");
    }

    @Test
    void testDepositValidAmount() throws InvalidAccountAmountException, InvalidAccountAmountDepositOrWithdrawException {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should increase by deposit amount");
    }

    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        assertThrows(InvalidAccountWithdrawException.class, () -> account.withdraw(200.0),
                "Withdrawing more than balance should throw exception");
    }
}
