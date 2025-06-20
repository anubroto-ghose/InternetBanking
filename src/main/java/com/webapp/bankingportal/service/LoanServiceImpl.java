package com.webapp.bankingportal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.LoanDTO;
import com.webapp.bankingportal.entity.Loan;
import com.webapp.bankingportal.repository.LoanRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public LoanDTO applyLoan(LoanDTO dto) {
        Loan loan = new Loan();
        loan.setCustomerId(dto.getCustomerId());
        loan.setAmount(dto.getAmount());
        loan.setTenureInMonths(dto.getTenureInMonths());
        loan.setInterestRate(dto.getInterestRate());
        loan.setLoanType(dto.getLoanType());
        loan.setStatus("PENDING");
        loan.setStartDate(LocalDate.now());
        loan.setEndDate(LocalDate.now().plusMonths(dto.getTenureInMonths()));
        return toDTO(loanRepository.save(loan));
    }

    @Override
    public LoanDTO getLoanById(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        return toDTO(loan);
    }

    @Override
    public List<LoanDTO> getLoansByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public LoanDTO updateLoanStatus(Long id, String status) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        loan.setStatus(status);
        return toDTO(loanRepository.save(loan));
    }

    private LoanDTO toDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setCustomerId(loan.getCustomerId());
        dto.setAmount(loan.getAmount());
        dto.setTenureInMonths(loan.getTenureInMonths());
        dto.setInterestRate(loan.getInterestRate());
        dto.setLoanType(loan.getLoanType());
        dto.setStatus(loan.getStatus());
        dto.setStartDate(loan.getStartDate());
        dto.setEndDate(loan.getEndDate());
        return dto;
    }
}
