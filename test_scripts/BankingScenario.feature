# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3461
# Epic: BANK-3409
# Generated on: 2025-07-14 10:49:45
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Banking Portal Scenarios

Scenario: User logs in to banking portal
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the dashboard

Scenario: User transfers money between accounts
    Given the user is on the dashboard
    When the user selects transfer option
    And provides valid transfer details
    Then the transfer should be successful
