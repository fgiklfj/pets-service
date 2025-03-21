package services;

import exceptions.ATMExceptionDomainModel;
import repointerfaces.AccountsRepo;
import entities.Account;
import entities.User;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AccountService {
    private final AccountsRepo accountsRepo;

    public AccountService(AccountsRepo repo) {
        accountsRepo = repo;
    }

    public void createNewAccount(User currUser, BigDecimal amount) throws ATMExceptionDomainModel {

        Account newAccount = new Account(amount);

        accountsRepo.addAccount(newAccount, currUser.getUserId());
    }


    public List<Account> showAllAccounts(User curruser) {
        return accountsRepo.showAllUserAccounts(curruser.getUserId());
    }

    public Account getByAccountId(UUID accountId) throws AccountNotFoundException {
        return accountsRepo.getByAccountId(accountId);
    }
}