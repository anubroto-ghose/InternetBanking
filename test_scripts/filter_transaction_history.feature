Feature: Filter Transaction History

  Background:
    Given User is logged into the banking portal
    And Transaction history data is available for the user

  Scenario: Filter transaction history by date range
    Given User is on the transaction history page
    When User sets a specific date range in the filters
    Then Transaction history data should be filtered based on the selected date range
