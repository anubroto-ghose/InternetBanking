# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3969
# Epic: BANK-3931
# Generated on: 2025-07-18 16:32:58
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval Workflow

Scenario: Dealsheet Approval Workflow
    Given a dealsheet is submitted for approval
    When an approver reviews and approves the dealsheet
    Then the approval status is updated

Scenario: Staffing Approval Workflow
    Given staffing changes are submitted for approval
    When an approver reviews and approves the changes
    Then the status is updated accordingly

Scenario: Travel Approval Workflow
    Given travel expenses are submitted for approval
    When an approver reviews and approves the expenses
    Then the approval entry is logged
