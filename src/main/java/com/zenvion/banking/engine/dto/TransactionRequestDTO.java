package com.zenvion.banking.engine.dto;

import java.math.BigDecimal;

import com.zenvion.banking.engine.model.TransactionAction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TransactionRequestDTO(

    @NotNull(message =  "Amount is required")
    BigDecimal amount,

    @NotNull(message = "Action is required")
    TransactionAction action,

    @Size(max = 255, message = "Description must be less than 255 characters")
    String description,

    @NotBlank(message = "Source account number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Source account number must be 10 digits")
    String sourceAccount,

    @Pattern(regexp = "^[0-9]{10}$", message = "Destination account number must be 10 digits")
    String destinationAccount
) {}
