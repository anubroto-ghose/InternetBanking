# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3330
# Epic: BANK-3299
# Generated on: 2025-07-09 09:41:49
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Verify unauthorized access prevention for high-risk transactions

Scenario: Verify unauthorized access to high-risk transactions
    Given the GET /accounts/{accountId}/transactions endpoint is available
    And high-risk transactions exist in the system
    When attempting to access high-risk transaction data without proper authorization
    Then the system should prevent unauthorized access to high-risk transaction details