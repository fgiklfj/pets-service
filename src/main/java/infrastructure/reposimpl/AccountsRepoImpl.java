package infrastructure.reposimpl;

import application.exceptions.AccountNotFoundException;
import domainmodel.entities.Account;
import domainmodel.repointerfaces.AccountsRepo;

import java.util.*;

public class AccountsRepoImpl implements AccountsRepo {
    private final Map<UUID, Account> accountRepo = new HashMap<>();
    private final Map<UUID, List<Account>> accountOfUserRepo = new HashMap<>();

    /**
     * Adds a new account for the given user ID.
     * @param newAccount the new account to add
     * @param userId the ID of the user to add the account to
     */
    @Override
    public void addAccount(Account newAccount, UUID userId) {
        List<Account> userAccounts = showAllUserAccounts(userId);


        userAccounts.add(newAccount);
        accountOfUserRepo.put(userId, userAccounts);
        accountRepo.put(newAccount.getID(), newAccount);
    }

    /**
     * Retrieve an account by its ID.
     * @param accountId the ID of the account to retrieve
     * @return the account with the given ID
     * @throws AccountNotFoundException if no account with the given ID exists
     */
    @Override
    public Account getByAccountId(UUID accountId) throws AccountNotFoundException {
        Account account = accountRepo.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account with ID " + accountId + " not found.");
        }
        return account;
    }

    /**
     * Retrieves all accounts associated with a given user ID.
     * @param userId the ID of the user whose accounts to retrieve
     * @return a list of all accounts associated with the user
     */
    public List<Account> showAllUserAccounts(UUID userId) {
        return accountOfUserRepo.getOrDefault(userId, new ArrayList<>());
    }
}
