/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3962
 * Epic: BANK-3931
 * Generated on: 2025-07-18 16:56:48
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.fpmbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FpmRateOverrideTest {

    @Test
    void testManualRateOverride() {
        // Preconditions
        assertTrue(LiveExchangeRateService.isAvailable());

        // Test Steps
        ManualRateOverridePage.overrideCurrencyRate("USD", "EUR", 0.82);

        // Expected Results
        assertTrue(CurrencyConversionService.isRateOverridden("USD", "EUR", 0.82));
    }
}