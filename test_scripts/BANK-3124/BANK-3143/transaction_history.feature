# Test Case ID: TC_TransactionHistory_002
# Generated from Jira Ticket: BANK-3143
# Epic: BANK-3124
# Generated on: 2025-07-07 16:43:52
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction History Filtering

  Scenario: Filter transaction history by date, amount, and type
    Given the user is logged into the banking portal
    When the user navigates to the transaction history page
    And the user filters transactions by date "2023-10-01"
    And the user filters transactions by amount "100"
    And the user filters transactions by type "Deposit"
    Then the transaction history should display results matching the filters