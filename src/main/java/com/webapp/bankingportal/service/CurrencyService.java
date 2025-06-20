package com.webapp.bankingportal.service;

import java.util.List;

import com.webapp.bankingportal.entity.Currency;

public interface CurrencyService {

	public Currency addOrUpdateCurrency(Currency currency);

	public List<Currency> getCurrencys();
	
	

}
