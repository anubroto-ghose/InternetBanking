# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3166
# Epic: BANK-3125
# Generated on: 2025-07-07 11:37:00
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Retrieve forex transaction history for a user with no transactions

  Scenario: User has no existing forex transactions
    Given the user has no existing forex transactions
    When the user requests the forex transaction history
    Then an empty array of transactions should be returned
