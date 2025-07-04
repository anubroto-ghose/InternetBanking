# Test Case ID: TC_Conversion_002
# Generated from Jira Ticket: BANK-2958
# Epic: BANK-749
# Generated on: 2025-07-04 15:52:23
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Input invalid amount in INR
    Given the user is on the currency conversion screen
    When the user inputs an invalid amount "abc"
    Then the system should display an error message "Invalid amount entered. Please enter a valid number in INR."
    And the system should not proceed with the conversion