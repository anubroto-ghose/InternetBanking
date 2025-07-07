# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3152
# Epic: BANK-3124
# Generated on: 2025-07-07 15:55:05
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Initiate forex transaction with insufficient funds
    Given the RESTful API endpoint for forex transactions is available
    And the customer has insufficient JPY amount for the transaction
    When I send a request to initiate a forex transaction from JPY to INR with amount 5000
    Then the response should indicate insufficient funds
    And the customer's JPY amount should remain unchanged