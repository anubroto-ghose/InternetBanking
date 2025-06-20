package com.webapp.bankingportal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long recipientId; // Customer/User ID
    private String type;      // EMAIL, SMS, PUSH
    private String message;
    private String status;    // SENT, FAILED, PENDING
    private LocalDateTime timestamp;

    // Getters and Setters
    // ...
}
