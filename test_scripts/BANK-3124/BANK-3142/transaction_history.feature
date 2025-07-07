# Test Case ID: TC_TransactionHistory_001
# Generated from Jira Ticket: BANK-3142
# Epic: BANK-3124
# Generated on: 2025-07-07 16:44:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: View Transaction History

  Scenario: User views transaction history with distinct entries for INR and JPY transactions
    Given the user is logged into the banking portal
    When the user navigates to the transaction history page
    Then the transaction history should display INR transactions
    And the transaction history should display JPY transactions
    And the transactions should be categorized correctly