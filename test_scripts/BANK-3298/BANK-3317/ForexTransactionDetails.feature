# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3317
# Epic: BANK-3298
# Generated on: 2025-07-09 09:40:40
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Viewing historical forex transaction details

  Scenario: User views historical forex transaction details
    Given the user is logged into the banking portal
    And the user has completed at least one forex transaction
    When the user navigates to the account statement section
    And clicks on the historical forex transaction entry
    Then the user should be able to view the historical forex transaction details including amount, rate, and converted total