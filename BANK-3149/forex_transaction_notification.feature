# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3149
# Epic: BANK-3124
# Generated on: 2025-07-07 15:55:56
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Notification

  Scenario: User receives notification upon failure of forex transaction
    Given the user is logged in with username "testUser" and password "testPassword"
    When the user initiates a forex transaction
    And cancels the forex transaction
    Then the user should receive a notification stating "Transaction failed"