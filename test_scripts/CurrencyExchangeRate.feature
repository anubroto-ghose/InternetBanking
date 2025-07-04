# Test Case ID: TC_ExchangeRate_002
# Generated from Jira Ticket: BANK-3075
# Epic: BANK-749
# Generated on: 2025-07-04 18:24:23
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Real-time Update of INR to USD Exchange Rate

  Scenario: User observes the exchange rate updates in real-time
    Given the user is on the currency exchange page
    When the user waits for 5 minutes
    Then the exchange rate should be updated in real-time
