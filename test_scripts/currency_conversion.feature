# Test Case ID: TC_Conversion_004
# Generated from Jira Ticket: BANK-2960
# Epic: BANK-749
# Generated on: 2025-07-04 15:37:13
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Verify handling of edge case INR amount
    Given the user is on the currency conversion screen
    When the user inputs an edge case amount in INR
    Then the application should gracefully handle the edge case
    And the converted value should still be accurate for edge case scenarios

  Background:
    Given the user is logged in with valid credentials

  Given the user is on the currency conversion screen:
    // Navigate to the currency conversion page

  When the user inputs an edge case amount in INR:
    // Input edge case amount in the input field

  Then the application should gracefully handle the edge case:
    // Verify that the application does not crash and handles the input correctly

  And the converted value should still be accurate for edge case scenarios:
    // Verify the conversion result is as expected