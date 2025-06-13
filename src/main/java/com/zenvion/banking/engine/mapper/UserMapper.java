package com.zenvion.banking.engine.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zenvion.banking.engine.dto.UserRequestDTO;
import com.zenvion.banking.engine.dto.UserResponseDTO;
import com.zenvion.banking.engine.model.User;

@Mapper(componentModel = "spring", uses = { AccountMapper.class })
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "account", ignore = true)
    User toEntity(UserRequestDTO dto);

    @Mapping(target = "account", source = "account")
    UserResponseDTO toResponseDTO(User user);
}
