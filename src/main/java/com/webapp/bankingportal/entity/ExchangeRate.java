package com.webapp.bankingportal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sourceCurrency;

    @Column(nullable = false)
    private String targetCurrency;

    @Column(nullable = false)
    private BigDecimal rate;

    private LocalDateTime lastUpdated;

    // Getters and Setters
    // ...
}
