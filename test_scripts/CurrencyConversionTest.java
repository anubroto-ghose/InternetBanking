package com.example.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CurrencyConversionTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCurrencyConversionWithDecimalPrecision() {
        // Mock API calls
        mockCurrencyConversionService();

        // Input amount in INR with decimal precision
        double inrAmount = 1234.5678;

        // Trigger currency conversion
        mockMvc.perform(post("/convertCurrency").param("fromCurrency", "INR").param("toCurrency", "USD").param("amount", String.valueOf(inrAmount))).andExpect(status().isOk());

        // Verify precision of converted amount in USD
        double convertedUsdAmount = performCurrencyConversion(inrAmount, "INR", "USD");
        assertEquals(1234.57, convertedUsdAmount, 0.001);
    }

    private void mockCurrencyConversionService() {
        // Mock service implementation
    }

    private double performCurrencyConversion(double amount, String fromCurrency, String toCurrency) {
        // Actual currency conversion logic
        return amount * 0.013; // Simplified for demonstration
    }
}