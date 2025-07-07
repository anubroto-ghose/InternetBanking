# Test Case ID: TC_Forex_005
# Generated from Jira Ticket: BANK-3150
# Epic: BANK-3124
# Generated on: 2025-07-07 15:55:35
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display Forex Transaction Details

  Scenario: User views forex transaction details
    Given the user is logged in
    When the user navigates to the forex transactions section
    Then the system should display transaction details including amount and currency type
