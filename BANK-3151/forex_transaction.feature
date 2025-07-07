# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3151
# Epic: BANK-3124
# Generated on: 2025-07-07 15:55:20
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Successful initiation of forex transaction from INR to JPY
    Given the RESTful API endpoint for forex transactions is available
    And the customer has valid and sufficient INR amount
    When I send a request to initiate a forex transaction from INR to JPY
    Then I should receive a confirmation of the transaction within 2 seconds
    And the customer's INR amount should be deducted
    And the equivalent JPY amount should be credited
    And no error messages should be displayed