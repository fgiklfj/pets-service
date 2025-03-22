package application.services;

import application.exceptions.AccountNotFoundException;
import domainmodel.entities.Account;
import domainmodel.entities.User;
import domainmodel.exceptions.ATMExceptionDomainModel;
import domainmodel.repointerfaces.AccountsRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AccountService {
    private final AccountsRepo accountsRepo;

    public AccountService(AccountsRepo repo) {
        accountsRepo = repo;
    }

    /**
     * Create a new account with the given amount of money, and add it to the user given.
     *
     * @param currUser the user to which the account should be added.
     * @param amount   the amount of money the account should start with.
     * @throws ATMExceptionDomainModel if the account cannot be created.
     */
    public void createNewAccount(User currUser, BigDecimal amount) throws ATMExceptionDomainModel {
        Account newAccount = new Account(amount);

        accountsRepo.addAccount(newAccount, currUser.getUserId());
    }


    /**
     * Retrieves a list of all accounts associated with the given user.
     *
     * @param curruser the user whose accounts are to be retrieved
     * @return a list of accounts belonging to the specified user
     */
    public List<Account> showAllAccounts(User curruser) {
        return accountsRepo.showAllUserAccounts(curruser.getUserId());
    }

    /**
     * Retrieve the account associated with the given ID.
     *
     * @param accountId the ID of the account to be retrieved
     * @return the account associated with the given ID
     * @throws AccountNotFoundException if the account with the given ID does not exist.
     */
    public Account getByAccountId(UUID accountId) throws AccountNotFoundException {
        return accountsRepo.getByAccountId(accountId);
    }
}