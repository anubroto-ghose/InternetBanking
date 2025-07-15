# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3465
# Epic: BANK-3409
# Generated on: 2025-07-15 13:29:36
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: High-Risk Login Authentication

  Scenario: User receives additional authentication prompt for high-risk login attempt
    Given the user is on the login page
    And the user has a high-risk fraud score
    When the user enters valid username "testuser" and valid password "validPassword"
    Then the system detects high-risk score during login
    When the user completes additional authentication steps with OTP "123456"
    Then the user should be successfully logged in and redirected to the dashboard
