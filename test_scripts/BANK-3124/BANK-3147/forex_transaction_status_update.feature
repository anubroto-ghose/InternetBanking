# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3147
# Epic: BANK-3124
# Generated on: 2025-07-07 16:42:35
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Status Update

  Scenario: User updates transaction status in real-time without refresh
    Given the user is logged into the banking portal
    When the user initiates a forex transaction
    Then the transaction status should be updated in real-time without requiring a page refresh
