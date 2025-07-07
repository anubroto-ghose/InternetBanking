# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3148
# Epic: BANK-3124
# Generated on: 2025-07-07 15:56:12
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Notification

  Scenario: User receives a notification after completing a forex transaction
    Given the user is logged in with valid credentials
      | email           | password |
      | user@example.com | password |
    When the user initiates a forex transaction with amount 1000
    Then the user should receive a notification saying "Forex transaction completed successfully!"