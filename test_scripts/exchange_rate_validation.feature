# Test Case ID: TC_ExchangeRate_005
# Generated from Jira Ticket: BANK-3078
# Epic: BANK-749
# Generated on: 2025-07-04 18:23:28
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Exchange Rate Validation

  Scenario: Validate exchange rate format
    Given the user is on the currency exchange page
    When the user clicks on the 'Get Exchange Rate' button
    Then the exchange rate should be displayed in a valid numeric format
