Feature: Transaction History Filtering
  As a banking customer
  I want to filter my transaction history by date range
  So that I can view transactions within a specific period

  Background:
    Given the banking application is running
    And the user is logged into their account

  Scenario: Filter transaction history by date range
    Given the user is on the transaction history page
    When the user sets the date range from "2023-01-01" to "2023-01-31"
    And the user clicks the filter button
    Then the transaction history should display only transactions within the specified date range
    And the transaction with ID "12345" should be present

  Scenario: No transactions within the specified date range
    Given the user is on the transaction history page
    When the user sets the date range from "2023-02-01" to "2023-02-28"
    And the user clicks the filter button
    Then the transaction history should display no transactions
