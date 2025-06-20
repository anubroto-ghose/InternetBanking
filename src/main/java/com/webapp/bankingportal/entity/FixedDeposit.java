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
public class FixedDeposit {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private Long accountId;

private BigDecimal principalAmount;
private BigDecimal interestRate;
private Integer tenureInMonths;
private LocalDate startDate;
private LocalDate maturityDate;
private String status; // ACTIVE, CLOSED

// Getters and Setters
// ...
}
