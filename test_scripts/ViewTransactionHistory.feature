Feature: View Transaction History Page

  Background:
    Given User is logged into banking portal

  Scenario: View transaction history with default filters
    When User navigates to the transaction history page
    Then Default filters are applied
    And Transaction history data is displayed correctly
