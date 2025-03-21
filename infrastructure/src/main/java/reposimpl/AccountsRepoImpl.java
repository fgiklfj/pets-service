package reposimpl;

import repointerfaces.AccountsRepo;
import entities.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AccountsRepoImpl implements AccountsRepo {
    private final HashMap<UUID, Account> accountRepo = new HashMap<>();
    private final HashMap<UUID, List<Account>> accountOfUserRepo = new HashMap<>();

    /**
     * @param newAccount
     */
    @Override
    public void addAccount(Account newAccount, UUID userId) {
        List<Account> userAccounts = accountOfUserRepo.get(userId);

        if (userAccounts == null) {
            userAccounts = new ArrayList<>();
            accountOfUserRepo.put(userId, userAccounts);
        }

        userAccounts.add(newAccount);

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
