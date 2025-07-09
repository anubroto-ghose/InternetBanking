# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3319
# Epic: BANK-3298
# Generated on: 2025-07-09 09:39:00
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Verify transaction history displays standard and forex transactions

  Scenario: User can view standard and forex transactions
    Given User is logged into their account
    When User navigates to transaction history
    Then Both standard and forex transactions are displayed with accurate details
    And User can differentiate between standard and forex transactions easily