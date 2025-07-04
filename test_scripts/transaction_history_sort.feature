# Test Case ID: TC_ViewTransaction_003
# Generated from Jira Ticket: BANK-2954
# Epic: BANK-749
# Generated on: 2025-07-04 15:38:54
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Sort Transaction History by Timestamp

  Scenario: User sorts transaction history
    Given the user is logged into the application
    And the user has performed multiple currency conversions
    When the user navigates to the transaction history section
    And the user clicks on the sorting option to organize entries by timestamp
    Then the transaction history should be rearranged with the latest conversion appearing first
