# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3461
# Epic: BANK-3409
# Generated on: 2025-07-15 13:30:39
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Banking Portal User Operations

  Scenario: User logs in and creates an account
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the account page

    When the user navigates to the account creation page
    And enters account details
    And clicks the create account button
    Then a success message should be displayed
    And the account should be created successfully
