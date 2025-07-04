# Test Case ID: TC_Exchange_001
# Generated from Jira Ticket: BANK-2962
# Epic: BANK-749
# Generated on: 2025-07-04 15:51:19
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Fetch current INR to USD exchange rate

  Scenario: Successfully fetch and display current INR to USD exchange rate
    Given the application is running
    When the user requests the current INR to USD exchange rate
    Then the application should display the current INR to USD exchange rate
    And the application should display the last updated timestamp
