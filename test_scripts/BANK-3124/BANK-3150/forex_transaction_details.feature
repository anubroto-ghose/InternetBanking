# Test Case ID: TC_Forex_005
# Generated from Jira Ticket: BANK-3150
# Epic: BANK-3124
# Generated on: 2025-07-07 16:41:49
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display Forex Transaction Details

  Scenario: User views forex transaction details
    Given User is logged into the system
    When User navigates to the forex transactions section
    Then The system shows transaction details including amount and currency type
    | Amount | Currency |
    | 1000   | INR      |