package com.zenvion.banking.engine.dto;

import java.time.Instant;
import java.time.LocalDate;

import com.zenvion.banking.engine.model.Status;

public record CardResponseDTO(String cardNumber, LocalDate expiryDate, Instant issuedAt, Status status) {

}
