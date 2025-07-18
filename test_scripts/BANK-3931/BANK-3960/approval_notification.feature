# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3960
# Epic: BANK-3931
# Generated on: 2025-07-18 16:57:09
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: User receives alerts for approval decisions

  Scenario: Approval decision notification
    Given approvers have made a decision on the financial entry
    When the approval decision notification is triggered
    Then users should receive an alert for the approval decision regarding the financial entry
