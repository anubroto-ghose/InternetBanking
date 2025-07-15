# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3463
# Epic: BANK-3409
# Generated on: 2025-07-15 13:30:04
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: User Login

  Scenario: Successful login with valid credentials
    Given User is on the login page
    And User has valid login credentials
    When User enters valid username and password
    And User clicks on the login button
    Then User is successfully logged in to the system
