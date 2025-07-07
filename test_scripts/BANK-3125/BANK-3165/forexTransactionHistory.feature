# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3165
# Epic: BANK-3125
# Generated on: 2025-07-07 11:37:28
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Retrieve forex transaction history

  Scenario: User retrieves forex transaction history successfully
    Given User is logged in
    When User requests forex transaction history
    Then System returns forex transactions with amounts in INR, JPY, exchange rates, and timestamps
