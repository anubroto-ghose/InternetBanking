Feature: Currency Conversion

  Scenario: Verify decimal precision in currency conversion from INR to USD
    Given I have an amount in INR
      | amountInINR |
      | 1234.56     |
    When I convert the amount to USD
    Then the converted amount should be accurate with precision
      | expectedInUSD |
      | 15.67         |