# Test Case ID: TC_TransactionHistory_004
# Generated from Jira Ticket: BANK-3068
# Epic: BANK-749
# Generated on: 2025-07-04 18:25:40
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Filter transaction history by currency

  Scenario: User filters transaction history to show only USD transactions
    Given the user has logged in
    And the user has multiple conversion transactions logged in different currencies
    When the user navigates to the transaction history section
    And the user applies a filter to show only transactions in "USD"
    Then only conversion logs with "USD" transactions should be displayed
