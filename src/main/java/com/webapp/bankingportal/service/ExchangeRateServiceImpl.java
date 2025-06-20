package com.webapp.bankingportal.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.ExchangeRateDTO;
import com.webapp.bankingportal.entity.ExchangeRate;
import com.webapp.bankingportal.repository.ExchangeRateRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository repository;

    @Override
    public ExchangeRateDTO updateRate(ExchangeRateDTO dto) {
        ExchangeRate rate = repository.findBySourceCurrencyAndTargetCurrency(
                dto.getSourceCurrency(), dto.getTargetCurrency()
        ).orElse(new ExchangeRate());

        rate.setSourceCurrency(dto.getSourceCurrency());
        rate.setTargetCurrency(dto.getTargetCurrency());
        rate.setRate(dto.getRate());
        rate.setLastUpdated(LocalDateTime.now());

        return toDTO(repository.save(rate));
    }

    @Override
    public ExchangeRateDTO getRate(String source, String target) {
        ExchangeRate rate = repository.findBySourceCurrencyAndTargetCurrency(source, target)
                .orElseThrow(() -> new RuntimeException("Rate not found"));
        return toDTO(rate);
    }

    @Override
    public BigDecimal convertCurrency(String source, String target, BigDecimal amount) {
        ExchangeRate rate = repository.findBySourceCurrencyAndTargetCurrency(source, target)
                .orElseThrow(() -> new RuntimeException("Rate not found"));
        return amount.multiply(rate.getRate());
    }

    private ExchangeRateDTO toDTO(ExchangeRate rate) {
        ExchangeRateDTO dto = new ExchangeRateDTO();
        dto.setSourceCurrency(rate.getSourceCurrency());
        dto.setTargetCurrency(rate.getTargetCurrency());
        dto.setRate(rate.getRate());
        dto.setLastUpdated(rate.getLastUpdated());
        return dto;
    }
}
