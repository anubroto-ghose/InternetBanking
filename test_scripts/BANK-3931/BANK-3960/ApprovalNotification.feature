# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3960
# Epic: BANK-3931
# Generated on: 2025-07-18 17:23:20
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval Notification

  Scenario: User receives an alert for approval decisions
    Given the approvers have made a decision on the financial entry
    When the user logs into the banking portal
    Then the user should receive an alert for approval decisions regarding the financial entry
    And the alert should contain the approval status
    And the alert should be displayed on the dashboard