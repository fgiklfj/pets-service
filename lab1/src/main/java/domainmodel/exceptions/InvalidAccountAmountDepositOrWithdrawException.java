package domainmodel.exceptions;

public class InvalidAccountAmountDepositOrWithdrawException extends ATMExceptionDomainModel {
    public InvalidAccountAmountDepositOrWithdrawException(String message) {
        super(message);
    }
}
