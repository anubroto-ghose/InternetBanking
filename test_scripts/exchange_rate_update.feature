# Test Case ID: TC_Exchange_002
# Generated from Jira Ticket: BANK-2963
# Epic: BANK-749
# Generated on: 2025-07-04 15:36:22
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Exchange Rate Update

  Scenario: User sees the updated exchange rate in real-time
    Given the user is on the exchange rate screen
    When the user stays on the exchange rate screen for 15 seconds
    Then the displayed exchange rate should be updated in real-time without requiring user intervention
