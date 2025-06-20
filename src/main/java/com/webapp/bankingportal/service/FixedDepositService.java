package com.webapp.bankingportal.service;

import java.util.List;

import com.webapp.bankingportal.dto.FixedDepositDTO;

public interface FixedDepositService {
    FixedDepositDTO createFixedDeposit(FixedDepositDTO dto);
    FixedDepositDTO getFixedDepositById(Long id);
    List<FixedDepositDTO> getFixedDepositsByAccountId(Long accountId);
    FixedDepositDTO closeFixedDeposit(Long id);
}
