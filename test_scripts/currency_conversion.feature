# Test Case ID: TC_Conversion_002
# Generated from Jira Ticket: BANK-3110
# Epic: BANK-3083
# Generated on: 2025-07-04 14:05:45
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Conversion from INR to JPY with invalid amount
    Given the user is logged in and navigated to the currency conversion page
    And the INR amount to be converted is an invalid negative number
    When the user enters a negative INR amount in the amount field
    And clicks on the 'Convert' button
    Then an appropriate error message is displayed for the invalid amount
    And no forex transaction is recorded in the database
    And the transaction history remains unchanged