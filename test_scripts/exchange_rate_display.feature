# Test Case ID: TC_Exchange_003
# Generated from Jira Ticket: BANK-2964
# Epic: BANK-749
# Generated on: 2025-07-04 15:50:47
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Displaying exchange rate with last updated timestamp

  Scenario: User views the displayed exchange rate
    Given the application has successfully fetched the current INR to USD exchange rate
    When the user views the exchange rate on the screen
    Then the displayed exchange rate includes a timestamp indicating when it was last updated
