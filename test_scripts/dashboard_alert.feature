# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3466
# Epic: BANK-3409
# Generated on: 2025-07-14 10:48:43
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Dashboard Alert

  Scenario: Successful alert sent to dashboard
    Given Alerts are enabled
    And System is processing a suspicious transaction
    When a fraudulent transaction is detected
    Then An alert should be immediately sent to the dashboard
    And The alert containing detailed information about the flagged transaction should be displayed on the dashboard in real-time