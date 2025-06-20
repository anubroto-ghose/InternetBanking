package com.webapp.bankingportal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.StatementDTO;
import com.webapp.bankingportal.entity.Statement;
import com.webapp.bankingportal.repository.StatementRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {

    @Autowired
    private StatementRepository statementRepository;

    @Override
    public StatementDTO generateStatement(Long accountId, LocalDate from, LocalDate to) {
        Statement stmt = new Statement();
        stmt.setAccountId(accountId);
        stmt.setFromDate(from);
        stmt.setToDate(to);
        stmt.setGeneratedDate(LocalDate.now());
        stmt.setFilePath("/statements/" + accountId + "-" + from + "-to-" + to + ".pdf");
        return toDTO(statementRepository.save(stmt));
    }

    @Override
    public List<StatementDTO> getStatementsByAccount(Long accountId) {
        return statementRepository.findByAccountId(accountId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private StatementDTO toDTO(Statement stmt) {
        StatementDTO dto = new StatementDTO();
        dto.setId(stmt.getId());
        dto.setAccountId(stmt.getAccountId());
        dto.setFromDate(stmt.getFromDate());
        dto.setToDate(stmt.getToDate());
        dto.setFilePath(stmt.getFilePath());
        dto.setGeneratedDate(stmt.getGeneratedDate());
        return dto;
    }
    
 
}
