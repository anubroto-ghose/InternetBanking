package com.webapp.bankingportal.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Long id;
    private Long recipientId;
    private String type;
    private String message;
    private String status;
    private LocalDateTime timestamp;
    // Getters and Setters
    // ...
}
