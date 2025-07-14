# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3458
# Epic: BANK-3409
# Generated on: 2025-07-14 10:50:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Logging of fraud detection actions without timestamps

  Scenario: Perform fraud assessment action without timestamp
    Given the system is operational and available
    When a fraud assessment action is performed without a timestamp
    Then the action should be logged without a timestamp