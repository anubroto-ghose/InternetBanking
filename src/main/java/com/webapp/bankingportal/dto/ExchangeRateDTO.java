package com.webapp.bankingportal.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateDTO {
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal rate;
    private LocalDateTime lastUpdated;
    // Getters and Setters
    // ...
}
