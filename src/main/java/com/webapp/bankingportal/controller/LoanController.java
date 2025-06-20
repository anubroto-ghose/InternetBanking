package com.webapp.bankingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.LoanDTO;
import com.webapp.bankingportal.service.LoanService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanDTO> applyLoan(@RequestBody LoanDTO dto) {
        return ResponseEntity.ok(loanService.applyLoan(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> getLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoanById(id));
    }

    @GetMapping("/customer/{customerId}")
    public List<LoanDTO> getLoansByCustomer(@PathVariable Long customerId) {
        return loanService.getLoansByCustomerId(customerId);
    }

    @PutMapping("/{id}/status")
    public LoanDTO updateLoanStatus(@PathVariable Long id, @RequestParam String status) {
        return loanService.updateLoanStatus(id, status);
    }
}
