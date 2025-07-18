# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3959
# Epic: BANK-3931
# Generated on: 2025-07-18 16:48:11
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Email Notification

  Scenario: Email notification sent to approvers when input is required
    Given Approvers exist for financial entry approval
    And Input is required from the approver
    When Assign the financial entry to an approver
    Then Wait for input approval request
    And An email notification is sent to the approver when their input is required