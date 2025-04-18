package application.exceptions;

public class IncorrectPasswordException extends ATMExceptionApplication {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
