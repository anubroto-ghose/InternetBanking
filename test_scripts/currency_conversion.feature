# Test Case ID: TC_Conversion_002
# Generated from Jira Ticket: BANK-3071
# Epic: BANK-749
# Generated on: 2025-07-04 18:25:23
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Convert invalid INR amount
    Given the user is on the currency conversion page
    When the user inputs an invalid INR amount "-500"
    And the user clicks the "Convert" button
    Then an error message should be displayed indicating that the input is invalid

  Scenario: Convert non-numeric INR amount
    Given the user is on the currency conversion page
    When the user inputs an invalid INR amount "abc"
    And the user clicks the "Convert" button
    Then an error message should be displayed indicating that the input is invalid
