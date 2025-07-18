# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3958
# Epic: BANK-3931
# Generated on: 2025-07-18 16:34:55
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: FPM Enhancements

Scenario: Role-Based Financial Approval Workflow
    Given the user is on the FPM portal
    When they submit a dealsheet for approval
    Then the dealsheet should show the status as submitted

Scenario: Real-Time Currency Rate Integration
    Given the user is on the FPM portal
    When they convert currencies for travel expenses
    Then the conversion should reflect the real-time exchange rates
