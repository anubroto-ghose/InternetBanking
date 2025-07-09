# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3333
# Epic: BANK-3299
# Generated on: 2025-07-09 09:38:58
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Password Reset Eligibility

Scenario: User with low risk level is allowed to reset password
    Given a user with low risk level
    When the user attempts to reset password
    Then the user is able to reset the password

Scenario: User with high risk level is prompted with additional security measures
    Given a user with high risk level
    When the user attempts to reset password
    Then the user is prompted with additional security measures
