package Exceptions;

public class InvalidUserPasswordException extends Exception {
    public InvalidUserPasswordException(String message) {
        super(message);
    }
}
