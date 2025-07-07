# Test Case ID: TC_ForexConversion_001
# Generated from Jira Ticket: BANK-3157
# Epic: BANK-3125
# Generated on: 2025-07-07 11:41:56
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion with Invalid Authentication

  Scenario: TC_ForexConversion_001_TC002
    Given User is authenticated
    And New forex conversion endpoint is accessible
    When Send a request to the forex conversion endpoint with invalid authentication
    Then The system should return a 401 Unauthorized response
