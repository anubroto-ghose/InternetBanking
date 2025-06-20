package com.webapp.bankingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.FixedDepositDTO;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.FixedDepositService;
import com.webapp.bankingportal.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/fixed-deposits")
@RequiredArgsConstructor
public class FixedDepositController {

    private FixedDepositService fixedDepositService;

    @PostMapping
    public ResponseEntity<FixedDepositDTO> createFD(@RequestBody FixedDepositDTO dto) {
        return ResponseEntity.ok(fixedDepositService.createFixedDeposit(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FixedDepositDTO> getFD(@PathVariable Long id) {
        return ResponseEntity.ok(fixedDepositService.getFixedDepositById(id));
    }

    @GetMapping("/account/{accountId}")
    public List<FixedDepositDTO> getFDsByAccount(@PathVariable Long accountId) {
        return fixedDepositService.getFixedDepositsByAccountId(accountId);
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<FixedDepositDTO> closeFD(@PathVariable Long id) {
        return ResponseEntity.ok(fixedDepositService.closeFixedDeposit(id));
    }
}
