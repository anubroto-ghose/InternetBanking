# Test Case ID: TC_ViewTransaction_005
# Generated from Jira Ticket: BANK-2956
# Epic: BANK-749
# Generated on: 2025-07-04 15:38:19
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: View Transaction History

  Scenario: User views transaction history with a large dataset
    Given the user is logged in as "testUser"
    When the user navigates to the transaction history section
    Then the transaction history should load efficiently without performance issues
    And the transaction history should display a large number of transactions
