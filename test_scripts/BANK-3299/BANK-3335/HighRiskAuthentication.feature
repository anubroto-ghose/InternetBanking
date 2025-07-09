# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3335
# Epic: BANK-3299
# Generated on: 2025-07-09 09:37:14
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: High Risk User Authentication

  Scenario: Prompt for additional authentication for high-risk user
    Given the user is on the login page
    And the user has high-risk assessment score
    When the user enters username and password
    And clicks on 'Login' button
    Then the user is prompted for additional authentication steps
    And the user must provide additional verification
    And the user is not logged in until verification is complete