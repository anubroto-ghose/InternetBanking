# Test Case ID: TC_Exchange_003
# Generated from Jira Ticket: BANK-2964
# Epic: BANK-749
# Generated on: 2025-07-04 15:36:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Displaying exchange rate including last updated timestamp

  Scenario: User views the displayed exchange rate on the screen
    Given the application has successfully fetched the current INR to USD exchange rate
    When the user navigates to the banking portal
    Then the displayed exchange rate should include a timestamp indicating when it was last updated

  Background:
    Given the account service returns an exchange rate of 74.85 and last updated timestamp of '2023-10-01T12:00:00Z'
