# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3095
# Epic: BANK-3083
# Generated on: 2025-07-04 14:12:55
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Scenario: Successful forex conversion with valid authentication token
    Given the user is authenticated and has a valid authentication token
    When the user sends a valid request to the forex conversion endpoint
    Then the system successfully converts the forex with the authenticated user