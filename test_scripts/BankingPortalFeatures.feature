# Test Case ID: TC_UpdateSchema_005
# Generated from Jira Ticket: BANK-3104
# Epic: BANK-3083
# Generated on: 2025-07-04 14:08:43
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Banking Portal Features

  Scenario: Successful Login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be logged in successfully

  Scenario: Transfer Funds
    Given the user is logged in
    When the user initiates a fund transfer
    Then the funds should be transferred successfully
