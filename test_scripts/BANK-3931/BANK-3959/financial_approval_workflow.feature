# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3959
# Epic: BANK-3931
# Generated on: 2025-07-18 16:34:45
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

  Scenario: Submit dealsheet for approval
    Given I am on the FPM platform
    When I submit a dealsheet for approval
    Then I should see the dealsheet status as 'submitted'

  Scenario: Approve dealsheet
    Given I am on the FPM platform
    When I approve a submitted dealsheet
    Then the dealsheet status should be 'approved'
