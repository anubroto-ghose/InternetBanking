# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3152
# Epic: BANK-3124
# Generated on: 2025-07-07 16:41:17
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Failed initiation of forex transaction from JPY to INR with insufficient funds
    Given the user has an account with insufficient JPY balance
    When the user initiates a forex transaction to convert 2000 JPY to INR
    Then an error message indicating insufficient funds should be displayed
    And the user's JPY amount should remain unchanged
