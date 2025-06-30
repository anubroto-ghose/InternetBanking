Feature: Filter Transaction History

  Scenario: User filters transaction history by date range
    Given the user is logged into the banking portal
    And transaction history data is available for the user
    When the user navigates to the transaction history page
    And sets the date range from "2023-01-01" to "2023-01-31"
    And clicks on the filter button
    Then the transaction history should display only transactions within the date range

  Scenario: User attempts to filter transaction history with no results
    Given the user is logged into the banking portal
    And transaction history data is available for the user
    When the user navigates to the transaction history page
    And sets the date range from "2023-02-01" to "2023-02-28"
    And clicks on the filter button
    Then the transaction history should display no results
