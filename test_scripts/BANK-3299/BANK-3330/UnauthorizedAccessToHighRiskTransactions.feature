# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3330
# Epic: BANK-3299
# Generated on: 2025-07-15 13:40:34
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Unauthorized Access Prevention for High-Risk Transactions

  Scenario: User attempts to access high-risk transaction data without authorization
    Given the user is not logged in
    When the user attempts to access the high-risk transaction data for account ID 12345
    Then the system should prevent unauthorized access and display an error message
