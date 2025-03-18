package Services;

import Exceptions.AccountAlreadyExistsException;
import Exceptions.InvalidAccountAmountException;
import RepoInterfaces.AccountsRepo;
import entities.Account;
import entities.User;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.UUID;

public class AccountService {
    private final AccountsRepo accountsRepo;

    public AccountService(AccountsRepo repo) {
        accountsRepo = repo;
    }

    public void CreateNewAccount(User currUser, double amount) throws AccountAlreadyExistsException, InvalidAccountAmountException, AccountNotFoundException {

        if (accountsRepo.GetByAccountId(currUser.getUser_id()) != null)
            throw new AccountAlreadyExistsException("User already has an account");

        Account newAccount = new Account(amount);

        accountsRepo.AddAccount(newAccount, currUser.getUser_id());
    }


    public List<Account> ShowAllAccounts(User curruser) {
        return accountsRepo.ShowAllUserAccounts(curruser.getUser_id());
    }

    public Account GetByAccountId(UUID accountId) throws AccountNotFoundException {
        return accountsRepo.GetByAccountId(accountId);
    }
}