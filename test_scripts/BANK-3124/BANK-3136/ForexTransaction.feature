# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3136
# Epic: BANK-3124
# Generated on: 2025-07-07 16:45:47
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Edge Case

  Scenario: Successful maximum value forex transaction
    Given a valid OAuth 2.0 access token
    And the user has permissions to perform forex transactions
    When the user sends a forex transaction request with the maximum allowable value
    Then the response code should be 200
    And the response message should be "Transaction successful"
    And the transaction details should be logged for audit