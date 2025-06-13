package com.zenvion.banking.engine.dto;

public record UserResponseDTO(String firstName, String lastName, String email, AccountResponseDTO account) {

}
