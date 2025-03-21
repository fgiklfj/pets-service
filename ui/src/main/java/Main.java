import exceptions.*;
import atmmenu.OneUserServiceMainMenu;

import javax.security.auth.login.AccountNotFoundException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws ATMExceptionDomainModel, ATMExceptionApplication, NoSuchAlgorithmException, AccountNotFoundException {
        OneUserServiceMainMenu tBank = new OneUserServiceMainMenu();
        tBank.mainMenu();
    }
}

