Feature: Currency Conversion
  As a user
  I want to convert currency accurately
  So that I can handle international transactions

  Background:
    Given the currency conversion engine is operational
    And the conversion rates are up-to-date

  Scenario: Verify decimal precision in INR to USD conversion
    Given an amount in INR with decimal precision
    When the currency conversion from INR to USD is triggered
    Then the converted amount in USD should reflect the same precision as the input

  Examples:
    | amountINR | expectedUSD |
    | 1234.56   | 16.71       |
