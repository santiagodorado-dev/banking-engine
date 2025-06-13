package com.zenvion.banking.engine.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zenvion.banking.engine.dto.AccountResponseDTO;
import com.zenvion.banking.engine.model.Account;

@Mapper(componentModel = "spring", uses = { CardMapper.class })
public interface AccountMapper {

    @Mapping(target = "card", source = "card")
    AccountResponseDTO toResponseDTO(Account account);
}
