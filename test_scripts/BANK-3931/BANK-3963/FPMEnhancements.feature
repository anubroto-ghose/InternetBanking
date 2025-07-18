# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3963
# Epic: BANK-3931
# Generated on: 2025-07-18 16:34:01
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow
  Scenario: An approver can approve a dealsheet
    Given the user is an approver
    And the dealsheet is awaiting approval
    When the user approves the dealsheet
    Then the dealsheet should be marked as approved

  Scenario: A user can save a dealsheet as draft
    Given the user is editing a dealsheet
    And the user wants to save the dealsheet as draft
    When the user saves the dealsheet
    Then the dealsheet should be marked as draft

Feature: Real-Time Currency Rate Integration
  Scenario: Application handles API failure during currency conversion
    Given the application is making a currency conversion with the API down
    When the conversion is triggered
    Then the application should gracefully handle the API failure