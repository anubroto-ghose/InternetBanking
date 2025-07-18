# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3958
# Epic: BANK-3931
# Generated on: 2025-07-18 17:24:00
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Email Notifications on Financial Entry Submission

  Scenario: User submits a financial entry
    Given the user is logged in with valid credentials
    When the user submits a financial entry
    Then an email notification should be sent to the user

  Background:
    Given the user is on the login page
    When the user enters "testUser" as username
    And the user enters "testPassword" as password
    And the user clicks the login button

  Scenario Outline: Submit financial entry and check email notification
    Given the user fills in the financial entry form with amount <amount> and description <description>
    When the user clicks the submit button
    Then an email notification should be sent to "user@example.com"

  Examples:
    | amount | description   |
    | 1000   | Test Entry    |