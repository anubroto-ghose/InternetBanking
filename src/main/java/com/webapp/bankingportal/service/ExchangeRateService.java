package com.webapp.bankingportal.service;

import java.math.BigDecimal;

import com.webapp.bankingportal.dto.ExchangeRateDTO;

public interface ExchangeRateService {
    ExchangeRateDTO updateRate(ExchangeRateDTO dto);
    ExchangeRateDTO getRate(String source, String target);
    BigDecimal convertCurrency(String source, String target, BigDecimal amount);
}