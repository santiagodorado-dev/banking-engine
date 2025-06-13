package com.zenvion.banking.engine.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.zenvion.banking.engine.model.TransactionAction;

public record TransactionResponseDTO(Long id, BigDecimal amount, TransactionAction action, String description,
        Instant transactionDate, String sourceAccount, String destinationAccount) {

}
