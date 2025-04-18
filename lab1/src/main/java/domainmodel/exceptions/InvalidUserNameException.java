package domainmodel.exceptions;

public class InvalidUserNameException extends ATMExceptionDomainModel {
    public InvalidUserNameException(String message) {
        super(message);
    }
}
