Feature: Currency Conversion
  As a bank customer
  I want to perform accurate currency conversions
  So that I can manage my financial transactions

  Scenario: Verify currency conversion with decimal precision
    Given the currency conversion engine is operational
    And an amount in INR with decimal precision is provided
    When the conversion is triggered
    Then the converted amount in USD should have the same precision

  Background:
    Given the application is running
    And the conversion system is accessible