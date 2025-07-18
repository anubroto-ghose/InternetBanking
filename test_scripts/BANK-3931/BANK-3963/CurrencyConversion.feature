# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3963
# Epic: BANK-3931
# Generated on: 2025-07-18 16:47:25
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

Scenario: Handle currency conversion during API failure
    Given API failure scenario is simulated
    When currency conversion operation is triggered
    Then application should handle API failure gracefully