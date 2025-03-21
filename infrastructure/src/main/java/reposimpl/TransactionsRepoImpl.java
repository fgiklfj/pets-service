package reposimpl;

import repointerfaces.TransactionsRepo;
import entities.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TransactionsRepoImpl implements TransactionsRepo {
    private final HashMap<UUID, List<Transaction>> transactionRepo = new HashMap<>();

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
