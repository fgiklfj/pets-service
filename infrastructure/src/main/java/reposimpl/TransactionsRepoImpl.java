package reposimpl;

import repointerfaces.TransactionsRepo;
import entities.Transaction;

import java.util.*;

public class TransactionsRepoImpl implements TransactionsRepo {
    private final Map<UUID, List<Transaction>> transactionRepo = new HashMap<>();

    @Override
    public void addTransaction(Transaction newTransaction, UUID accountId) {
        List<Transaction> accountTransactions = transactionRepo.get(accountId);

        if (accountTransactions == null) {
            accountTransactions = new ArrayList<>();
            transactionRepo.put(accountId, accountTransactions);
        }

        accountTransactions.add(newTransaction);
    }

    @Override
    public List<Transaction> getTransactionByAccountId(UUID accountId) {
        return transactionRepo.get(accountId);
    }
}
