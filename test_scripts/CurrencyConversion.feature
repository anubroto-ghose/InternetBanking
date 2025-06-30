Feature: Currency Conversion
  As a user
  I want to convert currency from INR to USD
  So that I can perform financial transactions

  Background:
    Given the currency conversion system is operational

  Scenario: Conversion of zero INR to USD
    Given the input INR amount is 0
    When the conversion is triggered
    Then the output USD amount should also be 0
