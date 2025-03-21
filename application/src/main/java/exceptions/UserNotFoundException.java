package exceptions;

public class UserNotFoundException extends ATMExceptionApplication {
    public UserNotFoundException(String message) {
        super(message);
    }
}
