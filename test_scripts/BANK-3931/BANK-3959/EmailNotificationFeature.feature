# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3959
# Epic: BANK-3931
# Generated on: 2025-07-18 16:43:06
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: EmailNotification

  Scenario: Email notification sent to approvers
    Given Approvers exist for financial entry approval.
    And Input is required from the approver.
    When Assigning the financial entry to an approver.
    Then An email notification is sent to the approver.
