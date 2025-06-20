package com.webapp.bankingportal.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatementDTO {
    private Long id;
    private Long accountId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String filePath;
    private LocalDate generatedDate;
    // Getters and Setters
    // ...
}
