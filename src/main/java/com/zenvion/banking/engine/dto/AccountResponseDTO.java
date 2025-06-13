package com.zenvion.banking.engine.dto;

import java.math.BigDecimal;

import com.zenvion.banking.engine.model.Status;

public record AccountResponseDTO(String accountNumber, BigDecimal balance, Status status, CardResponseDTO card) {

}
