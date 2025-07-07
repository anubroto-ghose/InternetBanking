# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3148
# Epic: BANK-3124
# Generated on: 2025-07-07 16:42:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Notification

  Scenario: User receives notification upon completion of forex transaction
    Given the user is logged into the system
    When the user initiates and completes a forex transaction
    Then the user should receive a notification about the transaction completion

  Background:
    Given the user "testUser" with password "testPassword" exists
    And the user is logged in

  Scenario Outline: Complete a forex transaction
    When the user initiates a forex transaction of <amount>
    Then the user receives a notification "Forex transaction completed successfully!"

  Examples:
    | amount |
    | 1000   |