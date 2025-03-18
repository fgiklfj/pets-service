package Services;

import RepoInterfaces.TransactionsRepo;
import entities.Transaction;

import java.util.List;
import java.util.UUID;

public class TransactionService {
    private final TransactionsRepo transactionsRepo;

    public TransactionService(TransactionsRepo repo){
        transactionsRepo = repo;
    }

    public void AddTransaction(Transaction trasns, UUID accountId){
        transactionsRepo.AddTransaction(trasns, accountId);
    }

    public List<Transaction> GetTransactionsListById(UUID accountId){
        return transactionsRepo.GetTransactionByAccountId(accountId);
    }
}
