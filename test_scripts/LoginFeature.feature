# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3463
# Epic: BANK-3409
# Generated on: 2025-07-14 10:49:20
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Successful login with valid credentials

  Scenario: Successful login
    Given User is on the login page
    And User has valid login credentials
    When Enter valid username and password
    And Click on the login button
    Then User is successfully logged in to the system
