# Test Case ID: TC_Conversion_001
# Generated from Jira Ticket: BANK-2957
# Epic: BANK-749
# Generated on: 2025-07-04 15:37:59
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Convert INR to USD
    Given the user is on the currency conversion screen
    When the user inputs a valid amount in INR
      | amount |
      | 100    |
    Then the application displays the converted value in USD
      | convertedAmount |
      | 13.50          |