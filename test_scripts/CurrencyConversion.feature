# Test Case ID: TC_Conversion_004
# Generated from Jira Ticket: BANK-3112
# Epic: BANK-3083
# Generated on: 2025-07-04 14:04:34
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Background:
    Given the user is logged in and on the currency conversion page

  Scenario: Verify error message for invalid amount during currency conversion
    When an invalid amount is entered for conversion
    And the user clicks on the 'Convert' button
    Then an appropriate error message is displayed
    And no forex transaction is recorded in the database
    And the transaction history remains unchanged