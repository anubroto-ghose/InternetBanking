# Test Case ID: TC_TransactionHistory_004
# Generated from Jira Ticket: BANK-3145
# Epic: BANK-3124
# Generated on: 2025-07-07 15:57:12
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction History Updates

  Scenario: User views transaction history and sees real-time updates
    Given the user is logged in
    And there are recent completed or canceled transactions
    When the user navigates to the transaction history page
    Then the transaction history should be displayed
    And the transaction history should update in real-time
