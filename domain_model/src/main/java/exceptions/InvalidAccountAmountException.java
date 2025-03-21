package exceptions;

public class InvalidAccountAmountException extends ATMExceptionDomainModel {
    public InvalidAccountAmountException(String message) {
        super(message);
    }
}
