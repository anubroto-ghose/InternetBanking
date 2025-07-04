Feature: Forex Exchange INR to USD Conversion

  Scenario: User converts INR to USD
    Given the user is on the forex exchange page
    When the user enters an amount of "1000" INR
    And clicks on the convert button
    Then the user should see the converted amount as "13.0 USD"
    And the timestamp of the exchange rate used should be displayed
    And the conversion should be logged successfully

  Scenario: User views current exchange rate
    Given the user is on the forex exchange page
    When the page loads
    Then the user should see the current exchange rate from INR to USD