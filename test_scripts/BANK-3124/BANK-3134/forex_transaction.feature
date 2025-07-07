# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3134
# Epic: BANK-3124
# Generated on: 2025-07-07 16:46:24
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Successful Forex Transaction

  Scenario: User performs a successful forex transaction
    Given a valid OAuth 2.0 access token
    And the user has permissions to perform forex transactions
    When the user sends a forex transaction request with the token
    Then the response code should be 200
    And the transaction should be successful
    And the transaction details should be logged for audit