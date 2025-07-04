# Test Case ID: TC_TransactionHistory_003
# Generated from Jira Ticket: BANK-3067
# Epic: BANK-749
# Generated on: 2025-07-04 18:25:56
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction History Sorting

  Scenario: Sort transaction history by timestamp
    Given the user is logged in
    When the user navigates to the transaction history section
    And the user clicks on the 'Sort by Timestamp' option
    Then the conversion logs should be sorted in chronological order based on the timestamp
