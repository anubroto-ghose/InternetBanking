# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3961
# Epic: BANK-3931
# Generated on: 2025-07-18 16:47:48
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

Scenario: Test currency conversion with live exchange rates
    Given Currency rate synchronization job executed successfully
    And Correct base and target currency provided
    When Trigger the currency rate synchronization job
    And Perform a currency conversion
    Then Verify the currency conversion reflects the most recent live exchange rates accurately