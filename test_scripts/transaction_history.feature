# Test Case ID: TC_ViewTransaction_004
# Generated from Jira Ticket: BANK-2955
# Epic: BANK-749
# Generated on: 2025-07-04 15:38:39
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction History Filtering

  Scenario: Filter transaction history by currency type
    Given the user is logged in
    And the user has performed conversions with different currency types
    When the user navigates to the transaction history section
    And the user applies the currency filter for "USD"
    Then only conversion logs matching "USD" should be displayed in the history

  Background:
    Given the user "testUser" has logged into the application with password "testPassword"
    And the user has performed the following transactions:
      | amount | currency |
      | 100    | USD      |
      | 50     | EUR      |
      | 75     | USD      |
