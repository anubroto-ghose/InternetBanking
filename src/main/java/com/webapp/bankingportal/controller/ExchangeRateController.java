package com.webapp.bankingportal.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.ExchangeRateDTO;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.ExchangeRateService;
import com.webapp.bankingportal.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private ExchangeRateService exchangeRateService;

    @PostMapping("/update")
    public ResponseEntity<ExchangeRateDTO> updateRate(@RequestBody ExchangeRateDTO dto) {
        return ResponseEntity.ok(exchangeRateService.updateRate(dto));
    }

    @GetMapping("/get")
    public ResponseEntity<ExchangeRateDTO> getRate(@RequestParam String source, @RequestParam String target) {
        return ResponseEntity.ok(exchangeRateService.getRate(source, target));
    }

    @GetMapping("/convert")
    public ResponseEntity<String> convertAmount(@RequestParam String source,
                                                @RequestParam String target,
                                                @RequestParam BigDecimal amount) {
        BigDecimal result = exchangeRateService.convertCurrency(source, target, amount);
        return ResponseEntity.ok("Converted Amount: " + result);
    }
}
