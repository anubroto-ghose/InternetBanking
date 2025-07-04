# Test Case ID: TC_Conversion_003
# Generated from Jira Ticket: BANK-2951
# Epic: BANK-749
# Generated on: 2025-07-04 15:39:42
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Reconnect to Live API

  Scenario: System attempts to reconnect to live API when available
    Given the external API is unreachable
    When the API becomes available
    Then the system should automatically reconnect to the live API
    And the refreshed exchange rates should be successfully retrieved
