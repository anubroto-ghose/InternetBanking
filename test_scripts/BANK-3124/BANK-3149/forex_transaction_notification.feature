# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3149
# Epic: BANK-3124
# Generated on: 2025-07-07 16:42:05
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Notification

  Scenario: User receives notification upon failure of forex transaction
    Given the user is logged in with username "testuser" and password "password"
    When the user initiates a forex transaction
    And the transaction fails
    And the user cancels the transaction
    Then the user should receive a notification stating "Transaction failed"