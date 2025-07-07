# Test Case ID: TC_ConvertCurrency_004
# Generated from Jira Ticket: BANK-3177
# Epic: BANK-3125
# Generated on: 2025-07-07 11:31:06
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Convert Currency

  Scenario: Attempt to access invalid forex conversion endpoint
    Given the user accesses the forex conversion endpoint
    Then the API response should indicate an error
