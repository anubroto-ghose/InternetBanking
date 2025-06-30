Feature: Currency conversion with decimal precision

  Background:
    Given the currency conversion engine is implemented
    And input values for INR to USD conversion with decimal precision are provided

  Scenario: Convert INR amount to USD with decimal precision
    Given an amount in INR with decimal precision
    When the currency conversion is triggered
    Then the precision of the converted amount in USD should be validated
