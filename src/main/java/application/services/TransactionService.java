package application.services;

import domainmodel.entities.Transaction;
import domainmodel.repointerfaces.TransactionsRepo;

import java.util.List;
import java.util.UUID;

public class TransactionService {
    private final TransactionsRepo transactionsRepo;

    public TransactionService(TransactionsRepo repo) {
        transactionsRepo = repo;
    }

    /**
     * Add a transaction to a particular account. The transaction is stored in the
     * system, and the account's transaction history is updated.
     *
     * @param trans     the transaction to add
     * @param accountId the account to which to add the transaction
     */
    public void addTransaction(Transaction trans, UUID accountId) {
        transactionsRepo.addTransaction(trans, accountId);
    }

    /**
     * Return a list of all transactions for a given account.
     *
     * @param accountId the account for which to retrieve transactions
     * @return a list of transactions for the given account
     */
    public List<Transaction> getTransactionsListById(UUID accountId) {
        return transactionsRepo.getTransactionByAccountId(accountId);
    }
}
