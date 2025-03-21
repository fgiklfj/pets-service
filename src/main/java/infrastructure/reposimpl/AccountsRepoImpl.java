package infrastructure.reposimpl;

import domainmodel.entities.Account;
import domainmodel.repointerfaces.AccountsRepo;

import javax.security.auth.login.AccountNotFoundException;
import java.util.*;

public class AccountsRepoImpl implements AccountsRepo {
    private final Map<UUID, Account> accountRepo = new HashMap<>();
    private final Map<UUID, List<Account>> accountOfUserRepo = new HashMap<>();

    /**
     * @param newAccount
     */
    @Override
    public void addAccount(Account newAccount, UUID userId) {
        List<Account> userAccounts = showAllUserAccounts(userId);


        userAccounts.add(newAccount);
        accountOfUserRepo.put(userId, userAccounts);
        accountRepo.put(newAccount.getID(), newAccount);
    }


    /**
     * @param accountId
     * @return
     */
    @Override
    public Account getByAccountId(UUID accountId) throws AccountNotFoundException {
        Account account = accountRepo.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account with ID " + accountId + " not found.");
        }
        return account;
    }


    public List<Account> showAllUserAccounts(UUID userId) {
        return accountOfUserRepo.getOrDefault(userId, new ArrayList<>());
    }
}
