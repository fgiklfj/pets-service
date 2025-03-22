package domainmodel.repointerfaces;

import application.exceptions.AccountNotFoundException;
import domainmodel.entities.Account;

import java.util.List;
import java.util.UUID;

public interface AccountsRepo {
    /**
     * Adds a new account for the given user ID.
     * @param newAccount the new account to add
     * @param userId the ID of the user to add the account to
     */
    void addAccount(Account newAccount, UUID userId);

    /**
     * Retrieve an account by its ID.
     * @param accountId the ID of the account to retrieve
     * @return the account with the given ID
     * @throws AccountNotFoundException if no account with the given ID exists
     */
    Account getByAccountId(UUID accountId) throws AccountNotFoundException;

    /**
     * Retrieves all accounts associated with a given user ID.
     * @param userId the ID of the user whose accounts to retrieve
     * @return a list of all accounts associated with the user
     */
    List<Account> showAllUserAccounts(UUID userId);
}
