# Test Case ID: TC_TransactionHistory_004
# Generated from Jira Ticket: BANK-3145
# Epic: BANK-3124
# Generated on: 2025-07-07 16:10:44
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Real-time update of transaction history

  Scenario: User observes real-time updates on transaction history
    Given the user is logged in with username "testUser" and password "testPassword"
    When the user navigates to the transaction history page
    Then the transaction history should display 3 transactions initially
    When a new transaction is completed
    Then the transaction history should update to display 4 transactions
