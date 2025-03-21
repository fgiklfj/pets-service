package domainmodel.repointerfaces;

import domainmodel.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionsRepo {
    public void addTransaction(Transaction newTransaction, UUID accountId);

    public List<Transaction> getTransactionByAccountId(UUID accountId);
}

