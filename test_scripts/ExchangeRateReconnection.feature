# Test Case ID: TC_Conversion_003
# Generated from Jira Ticket: BANK-3062
# Epic: BANK-749
# Generated on: 2025-07-04 18:27:24
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Automatic reconnection to the live API

  Scenario: Automatic reconnection to live API when initially down
    Given the external API is down
    When the conversion function is started
    Then the system should fall back to the cached exchange rate
    When the external API comes back online
    Then the system should automatically attempt to reconnect to the live API
    And the exchange rate should be updated accordingly
