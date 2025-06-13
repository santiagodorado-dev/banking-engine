package com.zenvion.banking.engine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenvion.banking.engine.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccount_Card_CardNumberAndAccount_Card_Pin(String cardNumber, String pin);

    boolean existsByEmail(String email);

    boolean existsByNationalId(String nationalId);
}
