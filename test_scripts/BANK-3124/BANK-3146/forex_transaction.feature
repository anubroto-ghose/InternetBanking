# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3146
# Epic: BANK-3124
# Generated on: 2025-07-07 16:42:51
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display ongoing forex transactions

  Scenario: User views ongoing forex transactions with pending status
    Given the user is logged in
    When the user navigates to the forex transactions section
    Then the system should display ongoing forex transactions with pending status
