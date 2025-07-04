# Test Case ID: TC_TransactionHistory_001
# Generated from Jira Ticket: BANK-3065
# Epic: BANK-749
# Generated on: 2025-07-04 18:26:29
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: View Transaction History

  Scenario: User views transaction history with valid conversion logs
    Given the user is logged in as "testuser" with valid credentials
    When the user navigates to the transaction history section
    Then the transaction history section should display the conversion logs correctly
    And each log should contain the details: INR amount, USD amount, exchange rate, and timestamp

  Background:
    Given the user has completed at least one conversion transaction
    And the transaction history is available for the user
