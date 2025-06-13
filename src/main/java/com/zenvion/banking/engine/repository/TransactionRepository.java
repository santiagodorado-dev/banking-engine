package com.zenvion.banking.engine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenvion.banking.engine.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySourceAccount_IdOrderByTransactionDateDesc(Long accountId);

    List<Transaction> findByDestinationAccount_IdOrderByTransactionDateDesc(Long accountId);

}
