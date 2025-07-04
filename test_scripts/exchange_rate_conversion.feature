# Test Case ID: TC_Conversion_003
# Generated from Jira Ticket: BANK-2959
# Epic: BANK-749
# Generated on: 2025-07-04 15:52:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Exchange Rate Conversion

  Scenario: Verify real-time exchange rate used for conversion
    Given the user is on the banking portal
    When the user inputs a valid INR amount of 1000
    And the conversion button is clicked
    Then the system should fetch the most recent exchange rate for INR to USD
    And the converted value should reflect the real-time rate
