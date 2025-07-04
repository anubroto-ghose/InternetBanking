# Test Case ID: TC_ViewTransaction_005
# Generated from Jira Ticket: BANK-2956
# Epic: BANK-749
# Generated on: 2025-07-04 15:52:58
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: View Transaction History

  Scenario: User views transaction history with large dataset
    Given the user is logged in as "testUser" with password "password123"
    When the user navigates to the transaction history section
    Then the transaction history should be displayed without performance issues
    And the transaction history should contain 1000 transactions
