# Test Case ID: TC_Conversion_004
# Generated from Jira Ticket: BANK-2960
# Epic: BANK-749
# Generated on: 2025-07-04 15:51:51
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Verify handling of edge case INR amount
    Given the user is on the currency conversion screen
    When the user inputs an edge case amount "0.000001" in INR
    And the user clicks on the convert button
    Then the system should gracefully handle the edge case
    And the converted value should be accurate for edge case scenarios
