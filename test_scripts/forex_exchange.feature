Feature: Forex Exchange Conversion

  Scenario: Convert INR to USD
    Given the user is on the forex conversion page
    When the user inputs "1000" INR
    And clicks on the convert button
    Then the user should see the converted amount displayed as "Converted Amount: 13.39 USD"

  Scenario: Display current exchange rate
    Given the user is on the forex conversion page
    When the page loads
    Then the user should see the current exchange rate displayed

  Scenario: Log conversion history
    Given the user has converted "1000" INR to USD
    When the user checks the conversion history
    Then the user should see the conversion logged with timestamp and rate used