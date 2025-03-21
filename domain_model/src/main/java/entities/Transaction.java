package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(UUID transId, UUID accountId, BigDecimal amount, LocalDateTime transTime) {
    public Transaction(UUID accountId, BigDecimal amount) {
        this(UUID.randomUUID(), accountId, amount, LocalDateTime.now());
    }
}

