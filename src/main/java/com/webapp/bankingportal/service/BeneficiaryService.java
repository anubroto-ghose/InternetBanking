package com.webapp.bankingportal.service;

import java.util.List;

import com.webapp.bankingportal.dto.BeneficiaryDTO;

public interface BeneficiaryService {
    BeneficiaryDTO addBeneficiary(BeneficiaryDTO dto);
    BeneficiaryDTO getBeneficiaryById(Long id);
    List<BeneficiaryDTO> getBeneficiariesByCustomerId(Long customerId);
    void deleteBeneficiary(Long id);
}
