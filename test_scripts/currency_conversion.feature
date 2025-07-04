# Test Case ID: TC_Conversion_002
# Generated from Jira Ticket: BANK-2958
# Epic: BANK-749
# Generated on: 2025-07-04 15:37:43
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Input invalid amount in INR and handle gracefully
    Given the user is on the currency conversion screen
    When the user inputs an invalid amount in INR
    Then the application should display a clear error message for invalid INR amounts
    And the system should not proceed with the conversion if the input is invalid
