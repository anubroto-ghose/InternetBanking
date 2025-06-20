package com.webapp.bankingportal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customerId;

    private BigDecimal amount;
    private Integer tenureInMonths;
    private BigDecimal interestRate;
    private String loanType; // e.g., PERSONAL, HOME, AUTO
    private String status; // e.g., PENDING, APPROVED, REJECTED, CLOSED

    private LocalDate startDate;
    private LocalDate endDate;

    // Getters and Setters
    // ...
}