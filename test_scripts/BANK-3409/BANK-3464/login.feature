# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3464
# Epic: BANK-3409
# Generated on: 2025-07-15 13:29:51
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Unsuccessful login with incorrect password

  Scenario: User attempts to login with an incorrect password
    Given the user is on the login page
    And the user has an invalid password
    When the user enters a valid username and an incorrect password
    And clicks on the login button
    Then the user should receive an error message indicating incorrect credentials