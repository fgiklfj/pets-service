package exceptions;

public class InvalidUserPasswordException extends Exception {
    public InvalidUserPasswordException(String message) {
        super(message);
    }
}
