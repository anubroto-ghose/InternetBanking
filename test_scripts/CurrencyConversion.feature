Feature: Currency Conversion
  As a user
  I want to convert currency from INR to USD
  So that I can make informed financial decisions

  Background:
    Given the currency conversion service is operational

  Scenario: Convert currency with decimal precision
    Given an amount of 1234.56789 INR
    When the user triggers the conversion
    Then the converted amount should be approximately 16.48116463 USD