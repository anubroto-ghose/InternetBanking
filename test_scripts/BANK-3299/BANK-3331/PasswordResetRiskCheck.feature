# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3331
# Epic: BANK-3299
# Generated on: 2025-07-09 09:40:51
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Password Reset Risk Check

  Scenario: Risk check before sending OTP
    Given user navigates to the POST /api/auth/password-reset/send-otp endpoint
    And risk check system is active
    When user triggers a password reset request
    Then system performs risk assessment before sending the OTP
    And OTP is sent only if the risk check passes successfully
    And user receives OTP for password reset if risk level is acceptable
    And user is notified if risk check fails and OTP is not sent