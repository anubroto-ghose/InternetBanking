# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3960
# Epic: BANK-3931
# Generated on: 2025-07-18 11:01:52
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

  Scenario: Submit a dealsheet for approval
    Given the user is on the dealsheet page
    When the user submits the dealsheet for approval
    Then the dealsheet status should be 'submitted'

  Scenario: Approve a dealsheet
    Given the user is on the dealsheet approval page
    When the user approves the dealsheet
    Then the dealsheet status should be 'approved'
