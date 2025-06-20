package com.webapp.bankingportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bankingportal.entity.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findBySourceCurrencyAndTargetCurrency(String source, String target);
}
