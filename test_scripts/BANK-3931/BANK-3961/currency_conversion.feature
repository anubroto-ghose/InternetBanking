# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3961
# Epic: BANK-3931
# Generated on: 2025-07-18 11:01:25
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion reflects live exchange rates

Scenario: Perform currency conversion using live rates
Given Currency rate synchronization job executed successfully
And Correct base and target currency provided
When Trigger the currency rate synchronization job
And Perform a currency conversion using the obtained live exchange rates
Then The currency conversion reflects the most recent live exchange rates accurately