# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3335
# Epic: BANK-3299
# Generated on: 2025-07-15 13:39:00
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: User Login with Fraud Detection

  Scenario: Prompt for additional authentication for high-risk user
    Given the user is on the login page
    And the user has a high-risk assessment score
    When the user enters their username
    And the user enters their password
    And the user clicks on the 'Login' button
    Then the user should be prompted for additional authentication steps
    And the user must provide additional verification
    And the user is not logged in until verification is complete
