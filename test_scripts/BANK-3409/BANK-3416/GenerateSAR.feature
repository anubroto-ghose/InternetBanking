# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3416
# Epic: BANK-3409
# Generated on: 2025-07-10 09:07:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Generate SAR for flagged transactions

Scenario: SAR generation for multiple flagged transactions
    Given that multiple transactions are flagged by the fraud detection system
    When SAR generation is triggered
    Then SAR should be successfully associated with all flagged transactions