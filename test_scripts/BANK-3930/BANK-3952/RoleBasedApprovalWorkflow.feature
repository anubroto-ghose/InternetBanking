# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3952
# Epic: BANK-3930
# Generated on: 2025-07-18 10:53:24
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Approval Workflow

  Scenario: Submit financial entries for approval
    Given a finance manager wants to submit financial entries
    When the financial entries are successfully submitted
    Then appropriate approvers should receive notifications
