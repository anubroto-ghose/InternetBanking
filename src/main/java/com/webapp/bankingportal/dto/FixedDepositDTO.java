package com.webapp.bankingportal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixedDepositDTO {
    private Long id;
    private Long accountId;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private Integer tenureInMonths;
    private LocalDate startDate;
    private LocalDate maturityDate;
    private String status;
    // Getters and Setters
    // ...
}
