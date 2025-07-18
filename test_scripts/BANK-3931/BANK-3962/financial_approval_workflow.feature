# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3962
# Epic: BANK-3931
# Generated on: 2025-07-18 11:01:00
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

Scenario: Submit dealsheet for approval
    Given the user is on the dealsheet page
    When they submit the dealsheet for approval
    Then the dealsheet should be in the 'submitted' status

Scenario: Approve dealsheet
    Given the user is on the approval dashboard
    When they approve the dealsheet
    Then the dealsheet status should change to 'approved'