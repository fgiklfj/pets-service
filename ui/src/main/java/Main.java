import exceptions.*;
import atmmenu.OneUserServiceMainMenu;

import javax.security.auth.login.AccountNotFoundException;

public class Main {
    public static void main(String[] args) throws AccountAlreadyExistsException, InvalidAccountAmountException, InvalidUserNameException, InvalidUserPasswordException, UserAlreadyExistsException, UserNotFoundException, IncorrectPasswordException, AccountNotFoundException, InvalidAccountAmountDepositOrWithdrawException, InvalidAccountWithdrawException {
        OneUserServiceMainMenu tBank = new OneUserServiceMainMenu();
        tBank.mainMenu();
    }
}

