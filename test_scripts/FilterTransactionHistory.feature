Feature: Filter Transaction History by Date Range

  Scenario: User filters transaction history by specific date range
    Given User is logged into the banking portal
    And Transaction history data is available for the user
    When User navigates to the transaction history page
    And Sets a specific date range in the filters
    Then Transaction history data is filtered based on the selected date range
