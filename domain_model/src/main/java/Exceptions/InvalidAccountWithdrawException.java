package Exceptions;

public class InvalidAccountWithdrawException extends Exception {
    public InvalidAccountWithdrawException(String message) {
        super(message);
    }
}
