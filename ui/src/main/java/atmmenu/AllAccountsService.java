package atmmenu;

import exceptions.AccountAlreadyExistsException;
import exceptions.InvalidAccountAmountDepositOrWithdrawException;
import exceptions.InvalidAccountAmountException;
import exceptions.InvalidAccountWithdrawException;
import repointerfaces.AccountsRepo;
import reposimpl.AccountsRepoImpl;
import services.AccountService;
import entities.Account;
import entities.User;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AllAccountsService {
    static Scanner sc = new Scanner(System.in);
    final AccountsRepo accountsRepo = new AccountsRepoImpl();
    final AccountService accountService = new AccountService(accountsRepo);


    private List<Account> allUserAccountsBalance(User activeUser) {
        List<Account> accounts = accountService.showAllAccounts(activeUser);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + 1 + ": " + accounts.get(i).getID() + ", balance: " + accounts.get(i).getBalance());
        }

        return accounts;
    }

    private UUID idUsersAccounts(User activeUser) {
        List<Account> accounts = allUserAccountsBalance(activeUser);

        int numAcc = sc.nextInt() - 1;

        return accounts.get(numAcc).getID();
    }

    public void accountsServiceMenu(User activeUser) throws AccountAlreadyExistsException, InvalidAccountAmountException, AccountNotFoundException, InvalidAccountAmountDepositOrWithdrawException, InvalidAccountWithdrawException {

        while (true) {
            System.out.println("\nACCOUNTS MENU:");
            System.out.println("1. Add new account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Select an account");
            System.out.println("4. Return to the Main Menu");

            int usersChoice = sc.nextInt();

            if (usersChoice == 1) {
                System.out.println("\nEnter an amount to create a new account");
                double amount = sc.nextDouble();
                accountService.createNewAccount(activeUser, amount);
                System.out.println("\nAccount was successfully created! \nChoose \"2\" to view all accounts");
            } else if (usersChoice == 2) {
                allUserAccountsBalance(activeUser);
            } else if (usersChoice == 3) {
                System.out.println("Select an account:");
                UUID accountId = idUsersAccounts(activeUser);
                Account currAccount = accountService.getByAccountId(accountId);

                OneAccountService prisluga = new OneAccountService();
                prisluga.accountMenuService(currAccount);
            } else if (usersChoice == 4) {
                System.out.println("\nReturning to the MAIN MENU...");
                break;
            } else {
                System.out.println("\nUnknown option, please, try again");
            }
        }

    }
}
