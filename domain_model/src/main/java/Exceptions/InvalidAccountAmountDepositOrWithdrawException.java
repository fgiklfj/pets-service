package Exceptions;

public class InvalidAccountAmountDepositOrWithdrawException extends Exception {
    public InvalidAccountAmountDepositOrWithdrawException(String message) {
        super(message);
    }
}
