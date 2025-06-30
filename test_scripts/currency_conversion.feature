Feature: Currency Conversion
  As a user
  I want to convert zero INR to USD
  So that I can verify the conversion result

  Background:
    Given the currency conversion engine is implemented
    And input value for INR to USD conversion is zero

  Scenario: Conversion of zero INR to USD
    Given the input amount in INR is zero
    When the currency conversion is triggered
    Then the converted amount in USD should be zero

  Scenario Outline: Multiple currency conversion attempts
    Given the input amount in INR is <amount>
    When the currency conversion is triggered
    Then the converted amount in USD should be <expected_amount>

    Examples:
      | amount | expected_amount |
      | 100    | 0.0             |
      | 500    | 0.0             |
      | 1000   | 0.0             |