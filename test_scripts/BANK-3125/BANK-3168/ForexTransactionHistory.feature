# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3168
# Epic: BANK-3125
# Generated on: 2025-07-07 11:35:52
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction History

  Scenario: Verify response structure when retrieving forex transaction history
    Given User has existing forex transactions
    When User requests the endpoint to retrieve forex transaction history
    Then The response structure includes fields for amount in INR, amount in JPY, exchange rate, and timestamp