package RepoInterfaces;

import entities.Account;
import entities.Transaction;

import java.util.UUID;

public interface TransactionsRepo {
    public void AddTransaction(Transaction newTransaction);

    public void DeleteTransaction(Transaction stupidTransaction);

    public Transaction GetTransaction(UUID accountId);
}

