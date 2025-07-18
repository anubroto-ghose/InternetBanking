# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3963
# Epic: BANK-3931
# Generated on: 2025-07-18 16:56:37
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Real-Time Currency Rate Integration

  Scenario: Handling application gracefully on API failure
    Given an API failure scenario is simulated
    When currency conversion operation is triggered
    Then the application should handle the failure gracefully