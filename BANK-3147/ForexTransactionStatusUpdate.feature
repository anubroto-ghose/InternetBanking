# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3147
# Epic: BANK-3124
# Generated on: 2025-07-07 15:56:28
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Update transaction status in real-time

  Scenario: User initiates a forex transaction and observes status update
    Given the user is logged in with username "testUser" and pin "1234"
    When the user initiates a forex transaction
    Then the transaction status should be updated without refreshing the page
    And the status should display "Transaction Successful"
