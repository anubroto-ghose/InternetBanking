# Test Case ID: TC_ForexConversion_001
# Generated from Jira Ticket: BANK-3158
# Epic: BANK-3125
# Generated on: 2025-07-07 11:41:24
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex conversion with expired authentication token

  Scenario: Send request to forex conversion endpoint with expired token
    Given User is authenticated
    And New forex conversion endpoint is accessible
    When User sends a request to the forex conversion endpoint with expired token
    Then System should return a 401 Unauthorized response