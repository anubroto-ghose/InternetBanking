# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3336
# Epic: BANK-3299
# Generated on: 2025-07-09 09:35:11
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Seamless Login for Low-Risk User

  Scenario: Login seamlessly as low-risk user
    Given the user is on the login page
    And the user has low-risk assessment score
    When the user enters username
    And the user enters password
    And the user clicks on 'Login' button
    Then the user is logged in seamlessly
    And the user is redirected to the dashboard without any additional steps
