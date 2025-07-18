# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3966
# Epic: BANK-3931
# Generated on: 2025-07-18 16:33:32
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

  Scenario: Dealsheet approval workflow
    Given a dealsheet is created
    When an approver reviews and approves the dealsheet
    Then the dealsheet should be marked as approved

  Scenario: Real-Time Currency Rate Integration
    Given a currency conversion request is made
    When the system fetches and applies the real-time exchange rate
    Then the conversion should be accurate
