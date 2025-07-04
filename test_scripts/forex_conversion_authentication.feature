# Test Case ID: TC_Forex_Conversion_002
# Generated from Jira Ticket: BANK-3106
# Epic: BANK-3083
# Generated on: 2025-07-04 14:07:42
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Failed forex conversion due to invalid authentication

  Scenario: Admin attempts to convert forex with invalid credentials
    Given Admin is logged in with invalid credentials
    When Admin tries to convert forex
    Then System should reject the transaction and display an authentication error message
