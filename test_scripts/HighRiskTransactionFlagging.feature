# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3472
# Epic: BANK-3409
# Generated on: 2025-07-14 10:47:29
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: High Risk Transaction Flagging

  Scenario: Automatically flag transactions during high-risk periods
    Given real-time transactions are being processed
    When high-risk transaction patterns are simulated
    Then system should automatically identify and flag transactions
    And flagged transactions should be handled appropriately