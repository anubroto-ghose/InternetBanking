package com.webapp.bankingportal.service;

import java.time.LocalDate;
import java.util.List;

import com.webapp.bankingportal.dto.StatementDTO;

public interface StatementService {
    StatementDTO generateStatement(Long accountId, LocalDate from, LocalDate to);
    List<StatementDTO> getStatementsByAccount(Long accountId);
}
