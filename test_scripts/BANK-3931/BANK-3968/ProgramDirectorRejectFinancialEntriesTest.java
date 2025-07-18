/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3968
 * Epic: BANK-3931
 * Generated on: 2025-07-18 16:55:41
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.fpmbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProgramDirectorRejectFinancialEntriesTest {

    @Test
    public void testProgramDirectorRejectsFinancialEntry() {
        // Preconditions
        // Program Director is logged in
        // Financial entries pending approval

        // Test Steps
        // Program Director navigates to the approval section
        // Program Director selects a financial entry to reject
        // Program Director rejects the financial entry

        // Assertions
        // Verify the success message is displayed
        // Verify financial entry status changes to 'Rejected'
        // Verify notifications are sent to the initiator
    }
}