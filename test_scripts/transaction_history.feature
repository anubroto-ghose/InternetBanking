# Test Case ID: TC_ViewTransaction_001
# Generated from Jira Ticket: BANK-2952
# Epic: BANK-749
# Generated on: 2025-07-04 15:39:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: View Transaction History

  Scenario: User views transaction history with valid data
    Given the user is logged in with valid credentials
    And the user has performed multiple currency conversions
    When the user navigates to the transaction history section
    Then the transaction history should display all conversion logs with details
    And each entry should include the INR amount, USD amount, exchange rate used, and timestamp
    And the list should be displayed in a user-friendly format with sorting and filtering options available
