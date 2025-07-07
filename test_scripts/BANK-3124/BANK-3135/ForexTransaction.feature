# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3135
# Epic: BANK-3124
# Generated on: 2025-07-07 16:46:10
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Unsuccessful Forex Transaction with Invalid OAuth 2.0 Authentication

  Scenario: User attempts to perform a forex transaction with an invalid token
    Given the user has an invalid OAuth 2.0 access token
    And the user has necessary permissions to perform forex transactions
    When the user sends a forex transaction request with the invalid token
    Then the transaction should fail
    And the response code should be 401 or 403
    And the error message should indicate token authentication failure
