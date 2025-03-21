package exceptions;

public class InvalidAccountAmountException extends Exception {
    public InvalidAccountAmountException(String message) {
        super(message);
    }
}
