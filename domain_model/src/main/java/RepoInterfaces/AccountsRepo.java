package RepoInterfaces;

import entities.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.UUID;

public interface AccountsRepo {
    public void AddAccount(Account newAccount, UUID user_id);

    public Account GetByAccountId(UUID accountId) throws AccountNotFoundException;

    public List<Account> ShowAllUserAccounts(UUID user_id);

}
