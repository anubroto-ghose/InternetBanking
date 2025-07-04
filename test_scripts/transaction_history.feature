# Test Case ID: TC_TransactionHistory_002
# Generated from Jira Ticket: BANK-3066
# Epic: BANK-749
# Generated on: 2025-07-04 18:26:11
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction History

  Scenario: Attempt to view transaction history with no conversion logs
    Given the user "testUser" has not completed any conversion transactions
    When the user navigates to the transaction history section
    Then the application displays a message indicating that there are no conversion logs available
