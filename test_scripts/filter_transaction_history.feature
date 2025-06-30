Feature: Filter Transaction History

  Scenario: Filter transaction history by specific date range
    Given User is logged into the banking portal
    And Transaction history data is available for the user
    When User navigates to the transaction history page
    And User sets date range filter from '01/01/2022' to '02/01/2022'
    Then Transaction history data is filtered based on the selected date range