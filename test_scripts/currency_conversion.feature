Feature: Currency Conversion
  Scenario: Verify decimal precision in currency conversion from INR to USD
    Given User is logged into the banking portal
      | username   | password     |
      | testuser   | password123  |
    When User inputs an amount in INR with decimal precision
      | amount  | currencyFrom | currencyTo |
      | 1234.56 | INR          | USD        |
    And triggers the currency conversion
    Then the conversion should handle decimal precision accurately
    And the converted amount in USD should reflect the same precision as the input
      | expectedAmount |
      | 15.00          |