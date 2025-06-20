package com.webapp.bankingportal.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.entity.Currency;
import com.webapp.bankingportal.service.CurrencyService;
import com.webapp.bankingportal.util.ApiMessages;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {
	

	private final CurrencyService currencyService;
	
    @PostMapping("/savecurrencies")
    public ResponseEntity<String> addCurrency(@RequestBody Currency currency) {
    	currencyService.addOrUpdateCurrency(currency);
        return ResponseEntity.ok(ApiMessages.CASH_DEPOSIT_SUCCESS.getMessage());
    }
    
    @GetMapping("/getcurrencies")
    public ResponseEntity<String> getCurrency() {
    	currencyService.getCurrencys();
        return ResponseEntity.ok(ApiMessages.CASH_DEPOSIT_SUCCESS.getMessage());
    }

}
