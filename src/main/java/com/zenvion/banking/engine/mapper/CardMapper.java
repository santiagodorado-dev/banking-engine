package com.zenvion.banking.engine.mapper;

import org.mapstruct.Mapper;

import com.zenvion.banking.engine.dto.CardResponseDTO;
import com.zenvion.banking.engine.model.Card;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardResponseDTO toResponseDTO(Card card);
}
