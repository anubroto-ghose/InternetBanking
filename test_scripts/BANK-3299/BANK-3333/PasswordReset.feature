# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3333
# Epic: BANK-3299
# Generated on: 2025-07-15 13:39:41
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Password Reset Eligibility Based on Risk Level

  Scenario: High-risk user attempts password reset
    Given a user with a high risk level
    When the user attempts to reset their password
    Then the system should prompt for additional security measures

  Scenario: Low-risk user attempts password reset
    Given a user with a low risk level
    When the user attempts to reset their password
    Then the system should allow the password reset
