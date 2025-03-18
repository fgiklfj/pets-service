package obsluga;

import Exceptions.*;
import RepoInterfaces.UserRepo;
import ReposImpl.UserRepoImpl;
import Services.UserService;
import entities.User;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Scanner;

public class ObslugaUsera {
    static Scanner sc = new Scanner(System.in);
    final UserRepo uRepo = new UserRepoImpl();
    final UserService USA = new UserService(uRepo);
    User activeUser = null;

    public void obslugaUsera() throws AccountAlreadyExistsException, InvalidAccountAmountException, InvalidUserNameException, InvalidUserPasswordException, UserAlreadyExistsException, UserNotFoundException, IncorrectPasswordException, AccountNotFoundException, InvalidAccountAmountDepositOrWithdrawException, InvalidAccountWithdrawException {
        System.out.println("HELLO! NOW YOU ARE IN T-BANK!");

        while (true) {
            System.out.println("\nMAIN MENU: ");
            System.out.println("1. Create new account");
            System.out.println("2. Login");
            System.out.println("3. Exit");


            if (activeUser != null) {
                System.out.println("4. Hack bank");
            }

            int usersChoice = sc.nextInt();

            if (usersChoice == 1) {
                System.out.println("\nEnter your username:");
                String username = sc.next();

                System.out.println("\nEnter your password:");
                String password = sc.next();
                USA.Registration(username, password);

                System.out.println("\nUser has successfully created!\nSelect option \"Log in\" to continue");

            } else if (usersChoice == 2) {
                System.out.println("\nEnter your username:");
                String username = sc.next();

                System.out.println("\nEnter your password:");
                String password = sc.next();

                activeUser = USA.LogIn(username, password);

                if (activeUser != null) {
                    System.out.println("\nYou have successfully entered in your profile:");
                    System.out.println(activeUser);

                    ObslugaAccounts obsluzhivatel = new ObslugaAccounts();
                    obsluzhivatel.obslugaAccounts(activeUser);
                }

                else {
                    System.out.println("\nWrong data, please, try again");
                }

            } else if (usersChoice == 3) {
                System.out.println("\nSee you soon in T-BANK!");
                break;
            } else if (usersChoice == 4 && activeUser != null) {
                System.out.println("\nHello, " + activeUser.getName() + "! T-BANK knows all about you \nWe have already downloaded yor browser history ;)");
            } else {
                System.out.println("\nUnknown option, please, try again");
            }
        }
    }
}
