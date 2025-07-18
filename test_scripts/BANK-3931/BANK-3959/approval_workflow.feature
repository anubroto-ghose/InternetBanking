# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3959
# Epic: BANK-3931
# Generated on: 2025-07-18 11:02:22
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow
  
  Scenario: Verify approval process for dealsheets
    Given I have a dealsheet ready for approval
    When I submit the dealsheet for approval
    Then I should receive an approval notification

  Scenario: Verify approval process for staffing
    Given I have a staffing request pending for approval
    When I approve the staffing request
    Then the status should be updated to 'approved'
