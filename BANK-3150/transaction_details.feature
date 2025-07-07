# Test Case ID: TC_Forex_005
# Generated from Jira Ticket: BANK-3150
# Epic: BANK-3124
# Generated on: 2025-07-07 16:09:09
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display transaction details

  Scenario: User views forex transaction details
    Given the user is logged into the banking portal
    When the user navigates to the forex transactions section
    Then the system should display transaction details including amount and currency type
    And the amount should be "1000"
    And the currency type should be "INR"

  Background:
    Given the user is logged in with valid credentials
