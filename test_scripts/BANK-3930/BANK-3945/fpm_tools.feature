# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3945
# Epic: BANK-3930
# Generated on: 2025-07-18 10:56:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

  Scenario: Submit a dealsheet for approval
    Given the user is logged in
    When the user submits a dealsheet for approval
    Then the dealsheet status should be 'submitted'

  Scenario: Approve a dealsheet
    Given an dealsheet is waiting for approval
    When the approver approves the dealsheet
    Then the dealsheet status should be 'approved'

  // Add more scenarios based on requirements
