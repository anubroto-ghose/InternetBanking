# Test Case ID: TC_TransactionHistory_003
# Generated from Jira Ticket: BANK-3144
# Epic: BANK-3124
# Generated on: 2025-07-07 16:43:31
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction History

  Scenario: Verify summary of pending transactions is available in transaction history
    Given the user is logged into the banking portal
    And there are pending transactions in the system
    When the user navigates to the transaction history page
    Then a clear summary of pending transactions should be displayed at the top of the transaction history layout
