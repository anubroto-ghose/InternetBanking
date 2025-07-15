# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3466
# Epic: BANK-3409
# Generated on: 2025-07-15 13:29:19
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Fraud Alert Dashboard

  Scenario: Successful alert sent to dashboard
    Given alerts are enabled for the dashboard
    And the system is processing a suspicious transaction
    When a fraudulent transaction is detected
    Then an alert should be displayed on the dashboard with details about the flagged transaction
