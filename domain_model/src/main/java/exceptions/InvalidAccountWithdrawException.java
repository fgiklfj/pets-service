package exceptions;

public class InvalidAccountWithdrawException extends ATMExceptionDomainModel {
    public InvalidAccountWithdrawException(String message) {
        super(message);
    }
}
