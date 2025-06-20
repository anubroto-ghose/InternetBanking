package com.webapp.bankingportal.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String filePath;
    private LocalDate generatedDate;

    // Getters and Setters
    // ...
}
