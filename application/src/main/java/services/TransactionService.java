package services;

import repointerfaces.TransactionsRepo;
import entities.Transaction;

import java.util.List;
import java.util.UUID;

public class TransactionService {
    private final TransactionsRepo transactionsRepo;

    public TransactionService(TransactionsRepo repo) {
        transactionsRepo = repo;
    }

    public void addTransaction(Transaction trans, UUID accountId) {
        transactionsRepo.addTransaction(trans, accountId);
    }

    public List<Transaction> getTransactionsListById(UUID accountId) {
        return transactionsRepo.getTransactionByAccountId(accountId);
    }
}
