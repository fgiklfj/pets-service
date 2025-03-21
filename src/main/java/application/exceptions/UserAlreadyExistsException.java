package application.exceptions;

public class UserAlreadyExistsException extends ATMExceptionApplication {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
