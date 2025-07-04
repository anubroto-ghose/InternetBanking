# Test Case ID: TC_Conversion_001
# Generated from Jira Ticket: BANK-3109
# Epic: BANK-3083
# Generated on: 2025-07-04 14:06:13
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Successful currency conversion from INR to JPY with valid amount
    Given the user is logged in and navigated to the currency conversion page
    And the INR amount to be converted is a valid positive number
    When I enter a valid positive INR amount in the amount field
    And click on the 'Convert' button
    Then the converted amount in JPY is displayed correctly
    And the forex transaction is recorded in the database
    And the transaction history is updated with the new forex transaction