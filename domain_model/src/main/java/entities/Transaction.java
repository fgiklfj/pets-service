package entities;

import java.util.UUID;
import java.time.LocalDateTime;

public class Transaction {
    private final UUID trans_id;
    private final UUID account_id;
    private final double amount;
    private final String trans_type;
    private final LocalDateTime trans_time;

    public Transaction(UUID account_id, double amount, String trans_type) {
        this.trans_id = UUID.randomUUID();
        this.account_id = account_id;
        this.amount = amount;
        this.trans_type = trans_type;
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

    public String getTrans_type() {
        return trans_type;
    }

    public LocalDateTime getTrans_time() {
        return trans_time;
    }


    @Override
    public String toString() {
        return "transaction{" +
                "trans_id=" + trans_id +
                ", account_id=" + account_id +
                ", amount=" + amount +
                ", trans_type=" + trans_type +
                ", trans_time=" + trans_time +
                "}";
    }
}
