# Test Case ID: TC_ForexConversion_001
# Generated from Jira Ticket: BANK-3159
# Epic: BANK-3125
# Generated on: 2025-07-07 11:40:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Scenario: Missing authentication token
    Given User is authenticated
    And New forex conversion endpoint is accessible
    When Send a request to the forex conversion endpoint with missing authentication token
    Then System should return a 401 Unauthorized response
