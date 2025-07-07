# Test Case ID: TC_ForexConversion_001
# Generated from Jira Ticket: BANK-3156
# Epic: BANK-3125
# Generated on: 2025-07-07 11:42:25
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: New forex conversion endpoint requires user authentication

Scenario: Unauthenticated user tries to access forex conversion endpoint
    Given the user is not authenticated
    When the user sends a request to the forex conversion endpoint
    Then the user should receive a 401 Unauthorized response