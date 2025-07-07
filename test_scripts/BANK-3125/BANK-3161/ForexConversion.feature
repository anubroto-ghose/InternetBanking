# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3161
# Epic: BANK-3125
# Generated on: 2025-07-07 11:39:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Attempt forex conversion with insufficient funds

  Scenario: User tries to convert forex with insufficient funds
    Given User is authenticated
    And User has insufficient funds
    When User initiates forex conversion with valid details
    Then System prevents the transaction
    And User receives an error message
