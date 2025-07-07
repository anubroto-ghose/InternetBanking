# Test Case ID: TC_Forex_005
# Generated from Jira Ticket: BANK-3155
# Epic: BANK-3124
# Generated on: 2025-07-07 15:54:13
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Successful initiation of forex transaction from JPY to INR
    Given the RESTful API endpoint for forex transactions is available
    And the customer has a valid and sufficient JPY amount
    When I send a request to initiate a forex transaction from JPY to INR
    Then the API should confirm the transaction within 2 seconds
    And the customer's JPY amount should be deducted
    And the equivalent INR amount should be credited
    And no error messages should be displayed
