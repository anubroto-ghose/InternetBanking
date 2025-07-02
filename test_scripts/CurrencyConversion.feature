Feature: Currency Conversion

  Scenario: Currency conversion from INR to USD with precision
    Given User is logged into banking portal
    When User enters amount 140.25 INR for conversion
    And Triggers the currency conversion
    Then Verify the precision of the converted amount in USD is 1.75
