# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3320
# Epic: BANK-3298
# Generated on: 2025-07-09 09:38:09
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Filtering transaction history by transaction type

  Scenario: Include forex transactions in the filter
    Given the user is logged into their account
    When the user accesses the transaction history filter options
    And selects to filter by transaction type
    And chooses to include forex transactions in the filter
    Then only forex transactions are displayed in the history
    And the user can see a clear separation of different transaction types
