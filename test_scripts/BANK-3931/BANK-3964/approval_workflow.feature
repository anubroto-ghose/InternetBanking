# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3964
# Epic: BANK-3931
# Generated on: 2025-07-18 16:33:48
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Approval Workflow

  Scenario: Submit financial records for approval
    Given the user is logged in
    When they submit a dealsheet for approval
    Then the dealsheet status should be 'draft'

  Scenario: Record approver's decision
    Given the user is logged in
    When they approve a staffing entry
    Then the staffing status should be 'approved'
