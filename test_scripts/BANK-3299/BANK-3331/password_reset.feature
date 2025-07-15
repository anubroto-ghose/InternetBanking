# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3331
# Epic: BANK-3299
# Generated on: 2025-07-15 13:40:18
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Password Reset with Risk Assessment

  Scenario: User requests OTP for password reset with acceptable risk
    Given the risk check system is active
    When the user triggers a password reset request for "user@example.com"
    Then the OTP should be sent successfully

  Scenario: User requests OTP for password reset with unacceptable risk
    Given the risk check system is active
    When the user triggers a password reset request for "riskyuser@example.com"
    Then the OTP should not be sent
    And the user should be notified that the risk check failed