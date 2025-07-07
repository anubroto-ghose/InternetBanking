# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3153
# Epic: BANK-3124
# Generated on: 2025-07-07 16:41:01
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Initiation of forex transaction with invalid currency type
    Given the RESTful API endpoint for forex transactions is available
    And the customer has a valid currency amount of 1000
    When the customer sends a request to initiate a forex transaction with an invalid currency type "INVALID_CURRENCY"
    Then an error message indicating invalid currency type should be displayed
    And no currency amount should be deducted from the customer's account
