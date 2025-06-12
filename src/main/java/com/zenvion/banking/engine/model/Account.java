package com.zenvion.banking.engine.model;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true, length = 10)
    private String accountNumber;

    @Setter
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();

        if (balance == null) {
            this.balance = BigDecimal.ZERO;
        }
    }
}
