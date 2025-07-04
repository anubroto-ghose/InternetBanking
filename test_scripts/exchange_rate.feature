# Test Case ID: TC_ExchangeRate_001
# Generated from Jira Ticket: BANK-3074
# Epic: BANK-749
# Generated on: 2025-07-04 18:24:36
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Exchange Rate Retrieval

  Scenario: Successful retrieval of current INR to USD exchange rate
    Given the user is on the currency exchange page
    When the user clicks on the 'Get Exchange Rate' button
    Then the application fetches and displays the current INR to USD exchange rate successfully
