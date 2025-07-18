# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3962
# Epic: BANK-3931
# Generated on: 2025-07-18 16:34:14
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: FPM Tools Application

Scenario: Role-Based Financial Approval Workflow
  Given a structured, role-based approval workflow is in place
  When dealsheets are updated with approval status
  Then the system should capture approval details and notify stakeholders

Scenario: Real-Time Currency Rate Integration
  Given real-time currency rate integration is active
  When travel costs are calculated with dynamic rates
  Then the system should store the applied rate and source

Scenario: Manual Rate Override Support Functionality
  Given live exchange rates are available
  When manual rate override feature is accessed
  And specific currency pair and rate are input
  Then the system should accept the manual rate override and use the specified rate in conversions
