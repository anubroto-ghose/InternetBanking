# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3961
# Epic: BANK-3931
# Generated on: 2025-07-18 16:34:26
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion Reflects Live Exchange Rates

  Scenario: Perform currency conversion with live exchange rates
    Given the currency rate synchronization job has executed successfully
    And correct base and target currency is provided
    When the currency conversion is performed
    Then the currency conversion should reflect the most recent live exchange rates accurately