package ui.atmmenu;

import application.services.TransactionService;
import domainmodel.entities.Account;
import domainmodel.entities.Transaction;
import domainmodel.exceptions.ATMExceptionDomainModel;
import domainmodel.repointerfaces.TransactionsRepo;
import infrastructure.reposimpl.TransactionsRepoImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class OneAccountService {
    static Scanner sc = new Scanner(System.in);
    final TransactionsRepo transactionsRepo = new TransactionsRepoImpl();
    final TransactionService transactionService = new TransactionService(transactionsRepo);


    public void accountMenuService(Account currAccount) throws ATMExceptionDomainModel {


        sc.useLocale(Locale.US);

        while (true) {
            System.out.println("\nCURRENT ACCOUNT MENU:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Return to the Accounts Menu");

            int usersChoice = sc.nextInt();

            if (usersChoice == 1) {
                System.out.println("\nEnter an amount of the money to add to the current account:");
                BigDecimal amount = sc.nextBigDecimal();

                currAccount.deposit(amount);
                Transaction trans = new Transaction(currAccount.getID(), amount);
                transactionService.addTransaction(trans, currAccount.getID());


                System.out.println("\nMoney was successfully added! \nNow your balance is:");
                System.out.println(currAccount.getBalance());
            } else if (usersChoice == 2) {
                System.out.println("\nEnter an amount of the money to withdraw from the current account:");
                BigDecimal amount = sc.nextBigDecimal();

                currAccount.withdraw(amount);
                Transaction trans = new Transaction(currAccount.getID(), amount.negate());
                transactionService.addTransaction(trans, currAccount.getID());
                System.out.println("\nMoney was successfully withdrawn! \nNow your balance is:");
                System.out.println(currAccount.getBalance());
            } else if (usersChoice == 3) {
                System.out.println("The balance of the current account is:");
                System.out.println(currAccount.getBalance());
            } else if (usersChoice == 4) {
                List<Transaction> transactions = transactionService.getTransactionsListById(currAccount.getID());
                for (int i = 0; i < transactions.size(); i++) {
                    System.out.println(i + 1 + ": " + transactions.get(i).transId() + ", amount: " + transactions.get(i).amount() + ", time:" + transactions.get(i).transTime());
                }
            } else if (usersChoice == 5) {
                System.out.println("\nReturning to the ACCOUNTS MENU...");
                break;
            } else {
                System.out.println("\nUnknown option, please, try again");
            }
        }


    }

}
