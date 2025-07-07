# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3148
# Epic: BANK-3124
# Generated on: 2025-07-07 16:09:50
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Notification

  Scenario: User receives notification upon completion of forex transaction
    Given the user is logged in with valid credentials
    When the user initiates a forex transaction of 1000 USD to EUR
    And completes the forex transaction
    Then the user should receive a notification stating "Forex transaction completed successfully!"