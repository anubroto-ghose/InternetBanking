Feature: Forex Conversion

  Scenario: User converts INR to JPY
    Given the user is logged in with valid credentials
    When the user navigates to the Forex conversion page
    And the user enters an amount of 1000 INR
    And the user clicks on the convert button
    Then the conversion result should be displayed in JPY
    And the user's INR account should be debited accordingly

  Scenario: User attempts to convert without logging in
    Given the user is not logged in
    When the user navigates to the Forex conversion page
    Then the user should be redirected to the login page

  Scenario: User enters an invalid amount
    Given the user is logged in with valid credentials
    When the user navigates to the Forex conversion page
    And the user enters an invalid amount
    And the user clicks on the convert button
    Then an error message should be displayed