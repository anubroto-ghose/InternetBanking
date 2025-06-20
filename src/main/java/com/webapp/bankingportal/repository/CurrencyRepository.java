package com.webapp.bankingportal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.bankingportal.entity.Currency;

@Repository
public interface CurrencyRepository  extends JpaRepository<Currency, Long> {
	
}
