# Test Case ID: TC_Exchange_003
# Generated from Jira Ticket: BANK-2964
# Epic: BANK-749
# Generated on: 2025-07-04 17:43:58
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display Exchange Rate

  Scenario: User views the displayed exchange rate including last updated timestamp
    Given the application has successfully fetched the current INR to USD exchange rate
    When the user navigates to the banking portal
    Then the displayed exchange rate should include a timestamp indicating when it was last updated
