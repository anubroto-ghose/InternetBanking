# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3149
# Epic: BANK-3124
# Generated on: 2025-07-07 16:09:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Notification

  Scenario: User receives notification upon failure of forex transaction
    Given the user is logged into the system
    When the user initiates a forex transaction
    And the transaction fails
    Then the user should receive a notification about the failure
