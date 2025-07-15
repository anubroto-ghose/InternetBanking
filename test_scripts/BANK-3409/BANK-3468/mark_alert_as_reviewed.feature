# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3468
# Epic: BANK-3409
# Generated on: 2025-07-15 13:28:47
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Mark Alert as Reviewed

  Scenario: Fraud analyst marks alert as reviewed
    Given an unreviewed alert is present on the dashboard
    When the fraud analyst selects the alert
    And the fraud analyst marks the alert as reviewed
    Then the alert should be flagged as reviewed
