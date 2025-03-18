package obsluga;

import Exceptions.AccountAlreadyExistsException;
import Exceptions.InvalidAccountAmountDepositOrWithdrawException;
import Exceptions.InvalidAccountAmountException;
import Exceptions.InvalidAccountWithdrawException;
import RepoInterfaces.AccountsRepo;
import ReposImpl.AccountsRepoImpl;
import Services.AccountService;
import entities.Account;
import entities.User;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ObslugaAccounts {
    static Scanner sc = new Scanner(System.in);
    final AccountsRepo accountsRepo = new AccountsRepoImpl();
    final AccountService accountService = new AccountService(accountsRepo);


    private List<Account> Huinya(User activeUser) {
        List<Account> accounts = accountService.ShowAllAccounts(activeUser);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + 1 + ": " + accounts.get(i).getID() + ", balance: " + accounts.get(i).getBalance());
        }

        return accounts;
    }

    private UUID AccountsForTupoiEblanUserZaebalMenya(User activeUser) {
        List<Account> accounts = Huinya(activeUser);

        int numAcc = sc.nextInt() - 1;

        return accounts.get(numAcc).getID();
    }

    public void obslugaAccounts(User activeUser) throws AccountAlreadyExistsException, InvalidAccountAmountException, AccountNotFoundException, InvalidAccountAmountDepositOrWithdrawException, InvalidAccountWithdrawException {

        while (true) {
            System.out.println("\nACCOUNTS MENU:");
            System.out.println("1. Add new account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Select an account");
            System.out.println("4. Return to the Main Menu");

            int usersChoice = sc.nextInt();

            if (usersChoice == 1) {
                System.out.println("\nEnter an amount to create a new account");
//                todo: read string > validate string > convert to double (if correct)
                double amount = sc.nextDouble();
                accountService.CreateNewAccount(activeUser, amount);
                System.out.println("\nAccount was successfully created! \nChoose \"2\" to view all accounts");
            } else if (usersChoice == 2) {
                Huinya(activeUser);
            } else if (usersChoice == 3) {
                System.out.println("Select an account:");
                UUID accountId = AccountsForTupoiEblanUserZaebalMenya(activeUser);
                Account currAccount = accountService.GetByAccountId(accountId);

                ObslugaODNOGOAccount prisluga = new ObslugaODNOGOAccount();
                prisluga.obsluzhiMenya(currAccount);
            } else if (usersChoice == 4) {
                System.out.println("\nReturning to the MAIN MENU...");
                break;
            } else {
                System.out.println("\nUnknown option, please, try again");
            }
        }

    }
}
