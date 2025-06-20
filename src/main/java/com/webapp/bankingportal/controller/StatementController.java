package com.webapp.bankingportal.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.StatementDTO;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.StatementService;
import com.webapp.bankingportal.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/statements")
@RequiredArgsConstructor
public class StatementController {

    private StatementService statementService;

    @PostMapping("/generate")
    public ResponseEntity<StatementDTO> generateStatement(@RequestParam Long accountId,
                                                          @RequestParam String fromDate,
                                                          @RequestParam String toDate) {
        return ResponseEntity.ok(statementService.generateStatement(accountId,
                LocalDate.parse(fromDate), LocalDate.parse(toDate)));
    }

    @GetMapping("/account/{accountId}")
    public List<StatementDTO> getStatementsByAccount(@PathVariable Long accountId) {
        return statementService.getStatementsByAccount(accountId);
    }
}