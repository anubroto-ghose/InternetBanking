# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3960
# Epic: BANK-3931
# Generated on: 2025-07-18 16:34:36
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

  Scenario: Submit dealsheet for approval
    Given the dealsheet is ready for submission
    When the user submits the dealsheet
    Then the dealsheet should be sent for approval

  Scenario: Approve dealsheet
    Given the dealsheet is pending approval
    When the approver reviews and approves the dealsheet
    Then the dealsheet status should be updated to approved