# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3336
# Epic: BANK-3299
# Generated on: 2025-07-15 13:38:37
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Seamless Login for Low-Risk User

  Scenario: User logs in with low-risk assessment
    Given the user is on the login page
    And the user has a low-risk assessment score
    When the user enters their username "lowRiskUser"
    And the user enters their password "securePassword123"
    And the user clicks on the 'Login' button
    Then the user should be logged in seamlessly
    And the user should be redirected to the dashboard