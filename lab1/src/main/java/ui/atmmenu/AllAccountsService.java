package ui.atmmenu;

import application.exceptions.ATMExceptionApplication;
import application.services.AccountService;
import domainmodel.entities.Account;
import domainmodel.entities.User;
import domainmodel.exceptions.ATMExceptionDomainModel;
import domainmodel.repointerfaces.AccountsRepo;
import infrastructure.reposimpl.AccountsRepoImpl;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
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

    public void accountsServiceMenu(User activeUser) throws ATMExceptionDomainModel, ATMExceptionApplication, AccountNotFoundException {

        sc.useLocale(Locale.US);


        while (true) {
            System.out.println("\nACCOUNTS MENU:");
            System.out.println("1. Add new account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Select an account");
            System.out.println("4. Return to the ui.Main Menu");

            int usersChoice = sc.nextInt();

            if (usersChoice == 1) {
                System.out.println("\nEnter an amount to create a new account");
                BigDecimal amount = sc.nextBigDecimal();
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
