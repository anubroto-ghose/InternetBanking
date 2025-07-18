# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3949
# Epic: BANK-3930
# Generated on: 2025-07-18 10:54:45
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Entry Approval Workflow

  Scenario: Approver approves financial entry
    Given the financial entry is ready for approval
    When the approver logs in
    And navigates to pending approvals section
    And selects a financial entry to approve
    And documents reasons for the approval
    Then the financial entry gets approved
    And an email notification is sent to the submitter
    And the status of the financial entry changes to 'Approved'