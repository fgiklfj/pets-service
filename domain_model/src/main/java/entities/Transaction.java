package entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final UUID trans_id;
    private final UUID account_id;
    private final double amount;
    private final LocalDateTime trans_time;

    public Transaction(UUID account_id, double amount) {
        this.trans_id = UUID.randomUUID();
        this.account_id = account_id;
        this.amount = amount;
        this.trans_time = LocalDateTime.now();
    }

    public UUID getTrans_id() {
        return trans_id;
    }

    public UUID getAccount_id() {
        return account_id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTrans_time() {
        return trans_time;
    }

}
