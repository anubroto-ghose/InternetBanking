package com.webapp.bankingportal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
    private Long id;
    private Long customerId;
    private BigDecimal amount;
    private Integer tenureInMonths;
    private BigDecimal interestRate;
    private String loanType;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    // Getters and Setters
    // ...
}
