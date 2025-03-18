import Exceptions.*;
import obsluga.ObslugaUsera;

import javax.security.auth.login.AccountNotFoundException;

public class Main {
    public static void main(String[] args) throws AccountAlreadyExistsException, InvalidAccountAmountException, InvalidUserNameException, InvalidUserPasswordException, UserAlreadyExistsException, UserNotFoundException, IncorrectPasswordException, AccountNotFoundException, InvalidAccountAmountDepositOrWithdrawException, InvalidAccountWithdrawException {
        ObslugaUsera obsluzhit = new ObslugaUsera();
        obsluzhit.obslugaUsera();
    }
}

