Feature: Currency Conversion

  Scenario: Verify currency conversion accuracy with decimal precision
    Given User has an amount in INR with decimal precision
    When User triggers the currency conversion
    Then The converted amount in USD should match the input precision
