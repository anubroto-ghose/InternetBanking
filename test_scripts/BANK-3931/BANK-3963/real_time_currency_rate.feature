# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3963
# Epic: BANK-3931
# Generated on: 2025-07-18 16:42:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Real-Time Currency Rate Integration

  Scenario: Handle currency conversion during API failure
    Given an API failure scenario is simulated
    When a currency conversion operation is triggered
    Then the application should handle the API failure gracefully
