package domainmodel.repointerfaces;

import domainmodel.entities.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.UUID;

public interface AccountsRepo {
    public void addAccount(Account newAccount, UUID userId);

    public Account getByAccountId(UUID accountId) throws AccountNotFoundException;

    public List<Account> showAllUserAccounts(UUID userId);

}
