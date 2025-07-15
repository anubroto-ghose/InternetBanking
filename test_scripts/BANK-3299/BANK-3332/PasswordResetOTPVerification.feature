# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3332
# Epic: BANK-3299
# Generated on: 2025-07-15 13:40:01
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Password Reset OTP Verification with Risk Assessment

  Scenario: Successful OTP verification with risk assessment
    Given the user has received the OTP for password reset
    When the user enters the received OTP
    And the system validates the OTP along with risk assessment
    Then the OTP verification should be successful
    And the system should log the risk scoring associated with OTP verification

  Scenario: Unauthorized OTP verification attempt
    Given the user has received the OTP for password reset
    When the user enters an invalid OTP
    And the system validates the OTP along with risk assessment
    Then the system should prevent the password reset
    And the system should log an unauthorized attempt to reset the password
