package exceptions;

public class AccountNotFoundException extends ATMExceptionApplication {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
