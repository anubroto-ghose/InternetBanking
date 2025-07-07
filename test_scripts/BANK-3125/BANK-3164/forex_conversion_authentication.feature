# Test Case ID: TC_Forex_005
# Generated from Jira Ticket: BANK-3164
# Epic: BANK-3125
# Generated on: 2025-07-07 11:38:05
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Token-based authentication for Forex Conversions

  Scenario Outline: Verify authentication for forex conversion
    Given User has a valid authentication token
    And Valid amount is available in the account
    When Invalid token is used for forex conversion
    Then System rejects the request
    And User receives authentication error message

  Examples:
    | TokenValid  | AccountAmount |
    | true        | 1000          |