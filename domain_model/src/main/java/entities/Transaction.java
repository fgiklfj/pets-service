package entities;

import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(UUID transId, UUID accountId, double amount, LocalDateTime transTime) {
    public Transaction(UUID accountId, double amount) {
        this(UUID.randomUUID(), accountId, amount, LocalDateTime.now());
    }
}

//public record Transaction(UUID transId, UUID accountId, double amount, LocalDateTime transTime) {
//    public Transaction(UUID accountId, double amount){
//        this(UUID.randomUUID(), accountId, amount, LocalDateTime.now());
//    }
//}