# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3959
# Epic: BANK-3931
# Generated on: 2025-07-18 17:23:40
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Email Notification for Approvers

  Scenario: Approver receives email notification when input is required
    Given approvers exist for financial entry approval
    And input is required from the approver
    When the financial entry is assigned to an approver
    Then an email notification is sent to the approver when their input is required
