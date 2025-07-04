# Test Case ID: TC_Conversion_003
# Generated from Jira Ticket: BANK-2959
# Epic: BANK-749
# Generated on: 2025-07-04 15:37:27
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Exchange Rate Conversion

  Scenario: Verify real-time exchange rate used for conversion
    Given I have entered a valid INR amount
    When I convert the amount to USD
    Then the system should fetch the most recent exchange rate for INR to USD
    And the converted value should reflect the real-time rate

  Background:
    Given the exchange rate for INR to USD is 0.013
