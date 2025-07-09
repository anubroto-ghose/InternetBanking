# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3332
# Epic: BANK-3299
# Generated on: 2025-07-09 09:39:59
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Password Reset OTP Verification

  Scenario: Verify OTP with Risk Logic
    Given User has received the OTP for password reset
    And Risk assessment logic is integrated into the OTP verification process
    When User enters the received OTP in the POST /api/auth/password-reset/verify-otp endpoint
    Then System validates the OTP along with risk assessment
    And OTP verification is successful only if risk assessment criteria are met
    And Unauthorized attempts to reset password are detected and prevented
    And System logs risk scoring associated with OTP verification