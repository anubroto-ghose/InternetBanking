# Test Case ID: TC_Conversion_004
# Generated from Jira Ticket: BANK-3063
# Epic: BANK-749
# Generated on: 2025-07-04 18:27:04
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Handling repeated API downtimes
    Given the external API is down
    When the user attempts to convert currency multiple times
    Then the system should notify the user that the API is unreachable and use the cached exchange rate

  Background:
    Given the external API is down

  Scenario Outline: Convert currency with API down
    When the user enters <amount> and clicks convert
    Then the system should display a notification "API is unreachable, using cached exchange rate."

    Examples:
      | amount |
      | 100    |
      | 200    |
      | 300    |