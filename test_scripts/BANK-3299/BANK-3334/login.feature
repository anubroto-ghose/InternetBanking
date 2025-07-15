# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3334
# Epic: BANK-3299
# Generated on: 2025-07-15 13:39:20
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: User Login with Fraud Detection

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    And the user has valid credentials
    When the user enters valid username
    And the user enters valid password
    And the user clicks on the 'Login' button
    Then the user is successfully logged in
    And the user is redirected to the dashboard
    And no warning or error messages are displayed
