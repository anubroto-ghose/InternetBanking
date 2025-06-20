package com.webapp.bankingportal.service;

import java.util.List;

import com.webapp.bankingportal.dto.LoanDTO;

public interface LoanService {
    LoanDTO applyLoan(LoanDTO dto);
    LoanDTO getLoanById(Long id);
    List<LoanDTO> getLoansByCustomerId(Long customerId);
    LoanDTO updateLoanStatus(Long id, String status);
}
