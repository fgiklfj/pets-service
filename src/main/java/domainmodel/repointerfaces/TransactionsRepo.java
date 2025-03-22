package domainmodel.repointerfaces;

import domainmodel.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionsRepo {
    /**
     * Adds a new transaction to the specified account's transaction history.
     * If the account does not have an existing transaction history, a new
     * list is created and associated with the account. The transaction is
     * then added to the list.
     *
     * @param newTransaction the transaction to be added.
     * @param accountId      the unique identifier of the account to which the transaction belongs.
     */
    void addTransaction(Transaction newTransaction, UUID accountId);

    /**
     * Retrieve a list of all transactions associated with a given account.
     *
     * @param accountId the unique identifier of the account whose transactions to retrieve
     * @return a list of all transactions associated with the given account
     */
    List<Transaction> getTransactionByAccountId(UUID accountId);
}