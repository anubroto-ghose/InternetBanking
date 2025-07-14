# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3457
# Epic: BANK-3409
# Generated on: 2025-07-14 10:50:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Logging of Fraud Assessment Actions

  Scenario: Perform a fraud assessment action
    Given the system is operational
    When the user performs a fraud assessment action
    Then the action should be logged with a timestamp