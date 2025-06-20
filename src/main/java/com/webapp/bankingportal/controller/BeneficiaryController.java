package com.webapp.bankingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.BeneficiaryDTO;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.BeneficiaryService;
import com.webapp.bankingportal.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/beneficiaries")
@RequiredArgsConstructor
public class BeneficiaryController {

    private BeneficiaryService beneficiaryService;

    @PostMapping
    public ResponseEntity<BeneficiaryDTO> addBeneficiary(@RequestBody BeneficiaryDTO dto) {
        return ResponseEntity.ok(beneficiaryService.addBeneficiary(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiary(@PathVariable Long id) {
        return ResponseEntity.ok(beneficiaryService.getBeneficiaryById(id));
    }

    @GetMapping("/customer/{customerId}")
    public List<BeneficiaryDTO> getByCustomer(@PathVariable Long customerId) {
        return beneficiaryService.getBeneficiariesByCustomerId(customerId);
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable Long id) {
        beneficiaryService.deleteBeneficiary(id);
    }
}
