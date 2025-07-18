# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3950
# Epic: BANK-3930
# Generated on: 2025-07-18 10:54:17
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow
  Scenario: Submit financial entry for approval
    Given the user is logged in
    And the financial entry is awaiting approval
    When the user submits the financial entry for approval
    Then the approval status should change to 'Submitted'

  Scenario: Reject financial entry
    Given the user is logged in as an approver
    And there is a pending approval
    When the user rejects the financial entry
    Then an email notification should be sent to the submitter
    And the approval status should change to 'Rejected'
