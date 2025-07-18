# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3962
# Epic: BANK-3931
# Generated on: 2025-07-18 16:56:48
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Manual Rate Override Support Functionality

  Scenario: User can manually override currency rate
    Given Live exchange rates are available
    When user overrides the rate for USD to EUR as 0.82
    Then the system should accept the manual rate override