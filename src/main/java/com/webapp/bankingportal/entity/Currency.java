package com.webapp.bankingportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "currencies")
public class Currency {

    @Id
    private String code; // Primary Key e.g., "USD", "EUR", "INR"

    private String name; // e.g., "US Dollar", "Euro", "Indian Rupee"
    
    private String origin;
}
