# Test Case ID: TC_TransactionHistory_004
# Generated from Jira Ticket: BANK-3145
# Epic: BANK-3124
# Generated on: 2025-07-07 16:43:07
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction History Updates

  Scenario: Real-time update of transaction history for completed or canceled transactions
    Given the user is logged in
    And there are recent completed or canceled transactions
    When the user navigates to the transaction history page
    Then the transaction history should be updated instantly
    And the transaction history should display completed transactions
    And the transaction history should display canceled transactions

  Background:
    Given the user has valid credentials
    When the user logs in with those credentials
    Then the user should be redirected to the dashboard
