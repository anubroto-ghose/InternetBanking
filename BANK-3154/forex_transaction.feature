# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3154
# Epic: BANK-3124
# Generated on: 2025-07-07 15:54:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Initiate forex transaction with non-existent customer
    Given the RESTful API endpoint for forex transactions is available
    When I send a request to initiate a forex transaction with a non-existent customer
    Then I should receive an error message indicating customer not found
    And no transaction should be initiated
