package RepoInterfaces;

import entities.Account;

import java.util.UUID;

public interface AccountsRepo {
    public void AddAccount(Account newAccount);

    public void DeleteAccount(Account stupidAccount);

    public Account GetAccount(UUID id);

}
