package domainmodel.exceptions;

public class InvalidUserPasswordException extends ATMExceptionDomainModel {
    public InvalidUserPasswordException(String message) {
        super(message);
    }
}
