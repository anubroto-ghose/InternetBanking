package com.webapp.bankingportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDTO {
    private Long id;
    private Long customerId;
    private Long targetAccountId;
    private String nickname;
    private String bankName;
    private String ifscCode;
    // Getters and Setters
    // ...
}