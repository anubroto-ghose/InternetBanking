Feature: Currency Conversion Precision

  Scenario: Verify decimal precision in currency conversion from INR to USD
    Given I am on the currency conversion page
    When I input an amount "1234.56" in INR
    And I trigger the currency conversion
    Then the converted amount should be "16.67" in USD
    And the precision should be accurate
