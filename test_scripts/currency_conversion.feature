Feature: Currency Conversion

  Scenario: Verify decimal precision in currency conversion from INR to USD
    Given I have an amount of "100.12345" INR
    When I convert the amount to USD
    Then the converted amount should be "74.12345" USD
