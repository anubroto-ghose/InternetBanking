# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3963
# Epic: BANK-3931
# Generated on: 2025-07-18 17:22:09
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion API Failure Handling

  Scenario: Handle API failure gracefully during currency conversion
    Given I am a finance administrator
    When I trigger a currency conversion operation with amount "100" from "USD" to "EUR"
    And the currency conversion API fails
    Then I should see an error message "Currency conversion service is temporarily unavailable. Please try again later."