package RepoInterfaces;

import entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionsRepo {
    public void AddTransaction(Transaction newTransaction, UUID accountId);

    public List<Transaction> GetTransactionByAccountId(UUID accountId);
}

