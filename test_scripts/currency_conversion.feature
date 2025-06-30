Feature: Currency Conversion
  As a banking customer
  I want to convert my currency from INR to USD
  So that I can verify the conversion accuracy with decimal precision

  Background:
    Given the currency conversion engine is implemented

  Scenario: Successful conversion with decimal precision
    Given I input an amount "1234.56" in INR
    When I trigger the currency conversion
    Then the converted amount in USD should be "15.56"
    And the conversion should handle decimal precision accurately

  Scenario: Conversion with rounding
    Given I input an amount "1000.999" in INR
    When I trigger the currency conversion
    Then the converted amount in USD should be rounded to "13.00"