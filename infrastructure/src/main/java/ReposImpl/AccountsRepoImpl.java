package ReposImpl;

import RepoInterfaces.AccountsRepo;
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
    public void AddAccount(Account newAccount, UUID user_id) {
        List<Account> userAccounts = accountOfUserRepo.get(user_id);

        if (userAccounts == null) {
            userAccounts = new ArrayList<>();
            accountOfUserRepo.put(user_id, userAccounts);
        }

        userAccounts.add(newAccount);

        accountRepo.put(newAccount.getID(), newAccount);
    }


    /**
     * @param accountId
     * @return
     */
    @Override
    public Account GetByAccountId(UUID accountId) throws AccountNotFoundException {
        Account account = accountRepo.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account with ID " + accountId + " not found.");
        }
        return account;
    }


    public List<Account> ShowAllUserAccounts(UUID user_id) {
        return accountOfUserRepo.getOrDefault(user_id, new ArrayList<>());
    }
}
