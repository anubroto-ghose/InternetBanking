# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3464
# Epic: BANK-3409
# Generated on: 2025-07-14 10:49:07
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: User login validation

Scenario: User enters incorrect password
    Given User is on the login page
    And User has invalid password
    When User enters valid username and incorrect password
    And clicks on the login button
    Then User receives an error message indicating incorrect credentials
