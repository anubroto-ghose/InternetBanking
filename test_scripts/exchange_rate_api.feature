# Test Case ID: TC_ExchangeRate_004
# Generated from Jira Ticket: BANK-3077
# Epic: BANK-749
# Generated on: 2025-07-04 18:23:43
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Exchange Rate API Downtime Handling

  Scenario: Unable to fetch exchange rate due to API downtime
    Given the external exchange rate API is down
    When I attempt to fetch the current INR to USD exchange rate
    Then I should see an error message indicating that the exchange rate could not be retrieved due to API downtime
