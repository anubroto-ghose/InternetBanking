# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3959
# Epic: BANK-3931
# Generated on: 2025-07-18 16:57:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Notification Email Sent to Approvers

  Scenario: Email notification sent to approver when input is required
    Given Approvers exist for financial entry approval
    And Input is required from the approver
    When the financial entry is assigned to an approver
    Then an email notification is sent to the approver
