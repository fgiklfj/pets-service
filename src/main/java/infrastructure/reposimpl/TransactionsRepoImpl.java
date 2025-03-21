package infrastructure.reposimpl;

import domainmodel.entities.Transaction;
import domainmodel.repointerfaces.TransactionsRepo;

import java.util.*;

public class TransactionsRepoImpl implements TransactionsRepo {
    private final Map<UUID, List<Transaction>> transactionRepo = new HashMap<>();

    /**
     * Adds a new transaction to the specified account's transaction history.
     * If the account does not have an existing transaction history, a new
     * list is created and associated with the account. The transaction is
     * then added to the list.
     *
     * @param newTransaction the transaction to be added.
     * @param accountId      the unique identifier of the account to which the transaction belongs.
     */
    @Override
    public void addTransaction(Transaction newTransaction, UUID accountId) {
        List<Transaction> accountTransactions = transactionRepo.get(accountId);

        if (accountTransactions == null) {
            accountTransactions = new ArrayList<>();
            transactionRepo.put(accountId, accountTransactions);
        }

        accountTransactions.add(newTransaction);
    }

    /**
     * Retrieve a list of all transactions associated with a given account.
     * @param accountId the unique identifier of the account whose transactions to retrieve
     * @return a list of all transactions associated with the given account
     */
    @Override
    public List<Transaction> getTransactionByAccountId(UUID accountId) {
        return transactionRepo.get(accountId);
    }
}
