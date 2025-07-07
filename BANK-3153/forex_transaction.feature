# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3153
# Epic: BANK-3124
# Generated on: 2025-07-07 16:08:16
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Initiate forex transaction with invalid currency type
    Given the RESTful API endpoint for forex transactions is available
    And the customer has a valid currency amount
    When I send a request to initiate a forex transaction with an invalid currency type
    Then I should receive an error message indicating invalid currency type
    And no currency amount should be deducted from the customer's account
