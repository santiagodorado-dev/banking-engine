package com.zenvion.banking.engine.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zenvion.banking.engine.dto.TransactionRequestDTO;
import com.zenvion.banking.engine.dto.TransactionResponseDTO;
import com.zenvion.banking.engine.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "transactionDate", ignore = true)
    @Mapping(target = "sourceAccount", ignore = true)
    @Mapping(target = "destinationAccount", ignore = true)
    Transaction toEntity(TransactionRequestDTO dto);

    @Mapping(target = "sourceAccount", source = "sourceAccount.accountNumber")
    @Mapping(target = "destinationAccount", source = "destinationAccount.accountNumber")
    TransactionResponseDTO toResponseDTO(Transaction transaction);
}
