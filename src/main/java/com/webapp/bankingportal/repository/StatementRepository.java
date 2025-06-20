package com.webapp.bankingportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bankingportal.entity.Statement;

public interface StatementRepository extends JpaRepository<Statement, Long> {
    List<Statement> findByAccountId(Long accountId);


}
