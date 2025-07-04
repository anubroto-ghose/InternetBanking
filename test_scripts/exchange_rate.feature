# Test Case ID: TC_ExchangeRate_003
# Generated from Jira Ticket: BANK-3076
# Epic: BANK-749
# Generated on: 2025-07-04 18:24:06
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display of last updated exchange rate

  Scenario: User retrieves current exchange rate with timestamp
    Given the user is logged in
    When the user retrieves the current exchange rate
    Then the displayed exchange rate should include a timestamp of when it was last updated

  Background:
    Given the exchange rate is "1.23" and last updated at "2023-10-01T12:00:00Z"

  Given the user is logged in:
    // Implement login step

  When the user retrieves the current exchange rate:
    // Implement retrieval step

  Then the displayed exchange rate should include a timestamp of when it was last updated:
    // Implement assertion step
