# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3961
# Epic: BANK-3931
# Generated on: 2025-07-18 17:22:56
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion
  As a finance administrator
  I want to ensure real-time exchange rates are integrated into financial calculations

  Scenario: Currency conversion reflects live exchange rates
    Given the currency rate synchronization job has been executed successfully
    And the base currency is "USD"
    And the target currency is "INR"
    When I trigger the currency rate synchronization job
    And I perform a currency conversion of "100" from "USD" to "INR"
    Then the conversion result should reflect the most recent live exchange rates accurately
    And the result should be "8265.0"